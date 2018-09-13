package com.tabao.core.utils;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * 
 * @author LiQiang 126870
 */
public class MqUtil
{

    private static Logger logger = LoggerFactory.getLogger(MqUtil.class);

    /**
     * 发送消息给指定的mq队列
     *
     * @param connection 连接对象
     * @param list 消息列表
     * @param destination 目标mq队列
     */
    public static void sendMessage(Connection connection, String info, String destination) throws Exception
    {
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination dest = new ActiveMQQueue(destination);
        MessageProducer producer = session.createProducer(dest);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        TextMessage msg = session.createTextMessage(info);
        producer.send(msg);

        /* connection.wait(50000L); */
        if (connection != null)
            connection.close();

    }

    /**
     * 接收消息,返回消息列表
     *
     * @param connection 连接对象
     * @param destination mq目标地址
     */
    public static List<String> ReceiveMessage(Connection connection, String destination)
    {
        List<String> list = new ArrayList<>();
        try
        {
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination dest = new ActiveMQQueue(destination);
            MessageConsumer consumer = session.createConsumer(dest);
            while (true)
            {
                Message msg = consumer.receive(100);
                // = consumer.receiveNoWait();
                if (msg == null)// 当队列消息为空时,跳出循环
                {
                    break;
                }
                String body = ((TextMessage) msg).getText();
                list.add(body);
            }
        }
        catch (JMSException e)
        {
            logger.error("连接activemq出现异常");
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (connection != null)
                    connection.close();
            }
            catch (JMSException e)
            {
                logger.error("关闭activemq连接出现异常");
                e.printStackTrace();
            }
        }
        return list;
    }
}
