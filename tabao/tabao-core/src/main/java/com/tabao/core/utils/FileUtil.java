package com.tabao.core.utils;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil
{
	
    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);
    
    public final static String MANAGE_CONTENTS = "manage";//运管目录
    public final static String OWNER_CONTENTS = "owner";//业户平台目录
    public final static String APP_CONTENTS = "app";//app目录

    public static void downloadFile(Workbook wb, HttpServletResponse response, String fileName,
            HttpServletRequest request) throws Exception
    {
        // 设置response参数，可以打开下载页面
        response.reset();
        if (isMSBrowser(request))
        {
            fileName = URLEncoder.encode(fileName, "UTF-8");
        }
        else
        {// 如果是谷歌、火狐则解析为ISO-8859-1
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        ServletOutputStream os = response.getOutputStream();
        try
        {
            wb.write(os);
        }
        catch (IOException e)
        {
            logger.info("导出excel失败", e);
        }

    }

    /**
     * 创建文件夹
     * Description
     * 
     * @param path remark
     */
    public static void createDir(String path)
    {
        File file = new File(path);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists())
        {
            parent.mkdirs();
        }
    }

    // 判断浏览器
    public static boolean isMSBrowser(HttpServletRequest request)
    {
        String[] IEBrowserSignals = { "MSIE", "Trident", "Edge" };
        String userAgent = request.getHeader("User-Agent");
        for (String signal : IEBrowserSignals)
        {
            if (userAgent.contains(signal))
            {
                return true;
            }
        }
        return false;
    }
    
	 /**
     * 
     * @Title: randomFileName   
     * @Description: 随机文件名
     * @param: @return 
     * @author: xuxiaohu  <xhxuc@isoftstone.com>
     * @date:   2017年5月16日 上午10:45:08      
     * @return: String
     */
    public static String randomFileName()
    {
        String randomStr = "1234567890";
        String fileName = "";
        Random random = new Random();
        int forMax = 10;
        for (int i = 0; i < forMax; i++)
        {
            fileName += randomStr.charAt(random.nextInt(10));
        }

        Date dt = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        return sdf.format(dt)+fileName;
    }
}
