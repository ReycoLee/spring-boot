/*
*//**
  * @(#)HttpThread.java 1.0 2017年11月27日
  * @Copyright:  Copyright 2010 - 2017 ISoftstone  Co. Ltd. All Rights Reserved.
  * @Modification History:
  * @version:     PROJNAME 1.0
  * @Date:        2017年11月27日
  * @Description: (Initialize)
  * @Reviewer:    
  * @Review Date:
*//*
package com.tabao.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

*//**
 * Description
 * @author LiQiang 126870
*//*
public class HttpThread implements Runnable
{
    private String url;
    
    private String header;
    
    private String content;
    
    private static Logger logger = LoggerFactory.getLogger(HttpThread.class);
    
    public HttpThread()
    {
        super();
    }

    public HttpThread(String url, String header, String content)
    {
        this.url = url;
        this.header = header;
        this.content = content;
    }

    @Override
    public void run()
    {
        try{
            String res = HttpUtil.post(header, url, null, content);
            logger.info(res);
        }catch(Exception e) {
            logger.error("调用接口失败，路径：{}，请求头：{}，参数：{}",url, header, content, e);
        }
    }
    
    
}

*/