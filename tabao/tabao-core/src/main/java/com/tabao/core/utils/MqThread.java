
/**
  * @(#)MqThread.java 1.0 2017年9月26日
  * @Copyright:  Copyright 2010 - 2017 ISoftstone  Co. Ltd. All Rights Reserved.
  * @Modification History:
  * @version:     PROJNAME 1.0
  * @Date:        2017年9月26日
  * @Description: (Initialize)
  * @Reviewer:    
  * @Review Date:
*/
package com.tabao.core.utils;

import javax.jms.Connection;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Description
 * @author LiQiang 126870
*/
public class MqThread implements Runnable
{
    private ActiveMQConnectionFactory mqConnectionFactory;
    
    private String destination;
    
    private String info;
    
    public MqThread()
    {
    	super();
    }

    public MqThread(ActiveMQConnectionFactory mqConnectionFactory, String destination, String info)
    {
        super();
        this.mqConnectionFactory = mqConnectionFactory;
        this.destination = destination;
        this.info = info;
    }


    @Override
    public void run()
    {
        try
        {
            Connection connection = mqConnectionFactory.createConnection();
            MqUtil.sendMessage(connection, info, destination);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getDestination()
    {
    
        return destination;
    }

    public void setDestination(String destination)
    {
    
        this.destination = destination;
    }

    public String getInfo()
    {
    
        return info;
    }

    public void setInfo(String info)
    {
    
        this.info = info;
    }
    
}

