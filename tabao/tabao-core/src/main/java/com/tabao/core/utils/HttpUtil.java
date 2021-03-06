/*
*//**
 * @(#)EmployeeController.java 1.0 2017年9月8日
 * @Copyright: Copyright 2010 - 2017 ISoftstone Co. Ltd. All Rights Reserved.
 * @Modification History:
 * @version: PROJNAME 1.0
 * @Date: 2017年9月8日
 * @Description: (Initialize)
 * @Reviewer:
 * @Review Date:
 *//*
package com.tabao.core.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

*//**
 * HttpClient 工具类
 *
 * @author LiQiang 
 *//*
public class HttpUtil
{

    public static final String POST = "POST";
    public static final String GET = "GET";
    public static final String DELETE = "DELETE";
    public static final String PUT = "PUT";

    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_URLENCODED = "application/x-www-form-urlencoded";
    public static final String OCTET_STREAM = "application/octet-stream";
    public static final String IMAGE_JPEG = "image/jpeg";
    public static final String IMAGE_PNG = "image/png";
    public static final String HTML = "text/html;charset=utf-8";

    private static Logger log = Logger.getLogger(HttpUtil.class);

    *//**
     * 
     * <p>desc:</p>
     * 
     * @author liqiang
     * @date 2015年5月10日上午11:06:25
     * @param url 请求地址
     * @param resultTarget 保存数据的目标地址
     * @param contentType
     * @param content 请求数据
     * @return
     *//*
    public static String post(String url, String resultTarget, String contentType, String content)
    {
        return sendRequest(url, resultTarget, contentType, POST, content);
    }

    public static JSONObject postToJsonObj(String url, String resultTarget, String contentType, String content)
    {
        JSONObject jsonObj = JSONObject.fromObject(post(url, resultTarget, contentType, content));
        return jsonObj;
    }

    public static String get(String url, String resultTarget, String contentType, String content)
    {
        return sendRequest(url, resultTarget, contentType, GET, content);
    }

    public static JSONObject getToJson(String url, String resultTarget, String contentType, String content)
    {
        JSONObject jsonObj = JSONObject.fromObject(get(url, resultTarget, contentType, content));
        return jsonObj;
    }

    public static String delete(String url)
    {
        return sendRequest(url, null, (String) null, DELETE, null);
    }

    public static String put(String url, String resultTarget, String contentType, String content)
    {
        return sendRequest(url, resultTarget, contentType, PUT, content);
    }

    public static String post(Map<String, String> header, String url, String resultTarget, String content)
    {
        return sendRequest(url, resultTarget, header, POST, content);
    }

    public static String get(Map<String, String> header, String url, String resultTarget, String content)
    {
        return sendRequest(url, resultTarget, header, GET, content);
    }

    public static String delete(Map<String, String> header, String url)
    {
        return sendRequest(url, null, header, DELETE, null);
    }

    public static String put(Map<String, String> header, String url, String resultTarget, String content)
    {
        return sendRequest(url, resultTarget, header, PUT, content);
    }

    *//**
     * 
     * <p>desc:</p>
     * 
     * @author liqiang
     * @date 2015年5月10日上午11:04:42
     * @param url
     * @param resultTarget
     * @param header
     * @param method
     * @param content
     * @return
     *//*
    private static String sendRequest(String url, String resultTarget, Map<String, String> header, String method,
            String content)
    {
        String result = null;
        OutputStream dos = null;
        InputStream is = null;
        try
        {
            URL myUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) myUrl.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod(method);
            if (header != null)
            {
                for (Map.Entry<String, String> ent : header.entrySet())
                {
                    conn.setRequestProperty(ent.getKey(), ent.getValue());
                }
            }
            conn.setRequestProperty("charset", "utf-8");
            conn.connect();
            if (content != null)
            {
                byte[] data = new byte[0];
                if (content != null && content.length() > 0)
                {
                    try
                    {
                        data = content.getBytes("UTF-8");
                    }
                    catch (UnsupportedEncodingException e)
                    {
                        log.error("系统不支持UTF-8编码方式", e);
                    }
                }
                dos = conn.getOutputStream();
                dos.write(data);
                dos.flush();
                try
                {
                    dos.close();
                    dos = null;
                }
                catch (IOException e)
                {
                    log.error("关闭流失败", e);
                }
            }
            if (HttpURLConnection.HTTP_OK == conn.getResponseCode())
            {// 成功返回数据
                is = conn.getInputStream();
                result = read(is, resultTarget);
                try
                {
                    is.close();
                    is = null;
                }
                catch (IOException e)
                {
                    log.error("关闭流失败", e);
                }
            }
            else
            {
                is = conn.getErrorStream();
                if (is == null)
                    is = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer sb = new StringBuffer();
                while (true)
                {
                    String s = br.readLine();
                    if (s == null)
                        break;
                    sb.append(s);
                }
                try
                {
                    is.close();
                    is = null;
                }
                catch (IOException e)
                {
                    log.error("关闭流失败", e);
                }
                result = sb.toString();
            }
        }
        catch (Exception e)
        {
            log.error("http请求失败", e);
        }
        finally
        {
            if (dos != null)
            {
                try
                {
                    dos.close();
                }
                catch (Exception e)
                {
                    log.error("关闭流失败", e);
                }
            }
            if (is != null)
            {
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    log.error("关闭流失败", e);
                }
            }
        }
        return result;
    }

    *//**
     * 
     * <p>desc:</p>
     * 
     * @author liqiang
     * @date 2015年5月10日上午11:04:59
     * @param url
     * @param resultTarget
     * @param contentType
     * @param method
     * @param content
     * @return
     *//*
    private static String sendRequest(String url, String resultTarget, String contentType, String method,
            String content)
    {
        Map<String, String> map = null;
        if (contentType != null)
        {
            map = new HashMap<String, String>();
            map.put("Content-Type", contentType);
        }
        return sendRequest(url, resultTarget, map, method, content);
    }

    *//**
     * 读取返回数据
     * 
     * @param in
     * @param fileStr
     * @return
     *//*
    private static String read(InputStream in, String fileStr)
    {
        String returnValue = null;
        if (fileStr != null)
        {
            FileOutputStream fos = null;
            File file = new File(fileStr);
            try
            {
                fos = new FileOutputStream(file);
                byte[] bts = new byte[1024];
                int sum = -1;
                while ((sum = in.read(bts)) != -1)
                {
                    fos.write(bts, 0, sum);
                    fos.flush();
                }
            }
            catch (Exception e)
            {
                log.error("读写文件异常", e);
                returnValue = "读取信息失败...";
            }
            finally
            {
                try
                {
                    if (fos != null)
                    {
                        fos.close();
                    }
                }
                catch (Exception e)
                {
                    log.error("关闭流失败", e);
                }
            }
        }
        else
        {
            try
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                StringBuffer sb = new StringBuffer();
                while (true)
                {
                    String s = br.readLine();
                    if (s == null)
                        break;
                    sb.append(s);
                }
                returnValue = sb.toString();
            }
            catch (Exception e)
            {
                log.error("读取信息异常", e);
                returnValue = "读取信息失败...";
            }
        }
        return returnValue;
    }

    public static void main(String[] args)
    {
        String content = null;
        String rs = HttpUtil.post("http://172.30.115.103:8090/datacenter/v1/employee/syncInfo/0", null, "application/json;charset=UTF-8", content);
        System.out.println(rs);
        System.out.println("ok");
    }
}
*/