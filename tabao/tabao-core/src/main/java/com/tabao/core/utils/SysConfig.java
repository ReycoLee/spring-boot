/**
 * @(#)SysConfig.java 1.0 2017年7月12日
 * @Copyright: Copyright 2010 - 2017 ISoftstone Co. Ltd. All Rights Reserved.
 * @Modification History:
 * @version: PROJNAME 1.0
 * @Date: 2017年7月12日
 * @Description: (Initialize)
 * @Reviewer:
 * @Review Date:
 */
package com.tabao.core.utils;

/**
 * 由spring管理
 * 映射sys.properties配置文件key关系
 * 
 * @author zhangz 48505
 */
public class SysConfig
{

    public static String redisHost;

    public static int redisPort;

    public static String redisAuth;

    public static int redisDbId;

    /**
     * 运管集成零散系统功能url
     */
    public static String lsUrl;
    /**
     * 上传路径
     */
    public static String imgPath;
    /**
     * 文件访问地址
     */
    public static String imgDomain;
    
    public static String fileUrl;

    /**
     * 物管系统地址
     */
    public static String etsUrl;
    
    public static String mapUrl;
    
    public static String map2Url;
    
    public static String jdeUrl;
    /**
     * 二维码跳转地址
     */
    public static String codeUrl;

    /**
     * 三方接口待办已办url
     */
    public static String dbUrl;
    
    public static String ybUrl;

    private static String urlEmail;

    private static String urlKnowledge;

    public static String appId;
    
    public static String appKey;
    
    public static String masterSecret;
    
    public static String empAppId;
    
    public static String empAppKey;
    
    public static String empMasterSecret;
    
    public static String adUrls;
    public static String adPrincipal;
    public static String adCredentials;
    public static String adDomain;
    public static String adCnSuffix;
    public static String adKeyStorefile;
    public static String adKeyStorepassword;
    
    // 有偿服务费用数据接口
    public static String serviceFeeUrl;


	public String getWorkOrderTopic() {
		return workOrderTopic;
	}

	public void setWorkOrderTopic(String workOrderTopic) {
		this.workOrderTopic = workOrderTopic;
	}

	//短信推送模板,APP下载地址
    public static String userapp;
    //短信推送模板,PC打开地址
    public static  String userpc;
    
    private  String workOrderTopic;

    private  String workOrderExpenseTopic;
    
    public static String getRedisHost()
    {

        return redisHost;
    }

    public static void setRedisHost(String redisHost)
    {

        SysConfig.redisHost = redisHost;
    }

    public static int getRedisPort()
    {

        return redisPort;
    }

    public static void setRedisPort(int redisPort)
    {

        SysConfig.redisPort = redisPort;
    }

    public static String getRedisAuth()
    {

        return redisAuth;
    }

    public static void setRedisAuth(String redisAuth)
    {

        SysConfig.redisAuth = redisAuth;
    }

    public static String getImgPath()
    {

        return imgPath;
    }

    public void setImgPath(String imgPath)
    {

        SysConfig.imgPath = imgPath;
    }

    public static String getImgDomain()
    {

        return imgDomain;
    }

    public static void setImgDomain(String imgDomain)
    {

        SysConfig.imgDomain = imgDomain;
    }

    public static int getRedisDbId()
    {

        return redisDbId;
    }

    public static void setRedisDbId(int redisDbId)
    {

        SysConfig.redisDbId = redisDbId;
    }

    public static String getLsUrl()
    {

        return lsUrl;
    }

    public static void setLsUrl(String lsUrl)
    {

        SysConfig.lsUrl = lsUrl;
    }

    public static String getEtsUrl()
    {

        return etsUrl;
    }

    public static void setEtsUrl(String etsUrl)
    {

        SysConfig.etsUrl = etsUrl;
    }

    public static String getCodeUrl()
    {
        return codeUrl;
    }

    public static void setCodeUrl(String codeUrl)
    {
        SysConfig.codeUrl = codeUrl;
    }

    public static String getDbUrl()
    {
        return dbUrl;
    }

    public static void setDbUrl(String dbUrl)
    {
        SysConfig.dbUrl = dbUrl;
    }

    public static String getYbUrl()
    {
        return ybUrl;
    }

    public static void setYbUrl(String ybUrl)
    {
        SysConfig.ybUrl = ybUrl;
    }

    public static String getUrlEmail()
    {

        return urlEmail;
    }

    public static void setUrlEmail(String urlEmail)
    {

        SysConfig.urlEmail = urlEmail;
    }

    public static String getUrlKnowledge()
    {

        return urlKnowledge;
    }

    public static void setUrlKnowledge(String urlKnowledge)
    {

        SysConfig.urlKnowledge = urlKnowledge;
    }

    public static String getAppId()
    {
        return appId;
    }

    public static void setAppId(String appId)
    {
        SysConfig.appId = appId;
    }

    public static String getAppKey()
    {
        return appKey;
    }

    public static void setAppKey(String appKey)
    {
        SysConfig.appKey = appKey;
    }

    public static String getMasterSecret()
    {
        return masterSecret;
    }

    public static void setMasterSecret(String masterSecret)
    {
        SysConfig.masterSecret = masterSecret;
    }

    public static String getFileUrl()
    {
    
        return fileUrl;
    }

    public static void setFileUrl(String fileUrl)
    {
    
        SysConfig.fileUrl = fileUrl;
    }

    public static String getMapUrl()
    {
    
        return mapUrl;
    }

    public static void setMapUrl(String mapUrl)
    {
    
        SysConfig.mapUrl = mapUrl;
    }

    public static String getJdeUrl()
    {
    
        return jdeUrl;
    }

    public static void setJdeUrl(String jdeUrl)
    {
    
        SysConfig.jdeUrl = jdeUrl;
    }

    public static String getAdUrls()
    {
    
        return adUrls;
    }

    public static void setAdUrls(String adUrls)
    {
    
        SysConfig.adUrls = adUrls;
    }

    public static String getAdPrincipal()
    {
    
        return adPrincipal;
    }

    public static void setAdPrincipal(String adPrincipal)
    {
    
        SysConfig.adPrincipal = adPrincipal;
    }

    public static String getAdCredentials()
    {
    
        return adCredentials;
    }

    public static void setAdCredentials(String adCredentials)
    {
    
        SysConfig.adCredentials = adCredentials;
    }

    public static String getAdDomain()
    {
    
        return adDomain;
    }

    public static void setAdDomain(String adDomain)
    {
    
        SysConfig.adDomain = adDomain;
    }

    public static String getAdCnSuffix()
    {
    
        return adCnSuffix;
    }

    public static void setAdCnSuffix(String adCnSuffix)
    {
    
        SysConfig.adCnSuffix = adCnSuffix;
    }

    public static String getAdKeyStorefile()
    {
    
        return adKeyStorefile;
    }

    public static void setAdKeyStorefile(String adKeyStorefile)
    {
    
        SysConfig.adKeyStorefile = adKeyStorefile;
    }

    public static String getAdKeyStorepassword()
    {
    
        return adKeyStorepassword;
    }

    public static void setAdKeyStorepassword(String adKeyStorepassword)
    {
    
        SysConfig.adKeyStorepassword = adKeyStorepassword;
    }

    public static String getMap2Url()
    {
    
        return map2Url;
    }

    public static void setMap2Url(String map2Url)
    {
    
        SysConfig.map2Url = map2Url;
    }

	public static String getEmpAppId() {
		return empAppId;
	}

	public static void setEmpAppId(String empAppId) {
		SysConfig.empAppId = empAppId;
	}

	public static String getEmpAppKey() {
		return empAppKey;
	}

	public static void setEmpAppKey(String empAppKey) {
		SysConfig.empAppKey = empAppKey;
	}

	public static String getEmpMasterSecret() {
		return empMasterSecret;
	}

	public static void setEmpMasterSecret(String empMasterSecret) {
		SysConfig.empMasterSecret = empMasterSecret;
	}

	public static String getUserapp() {
		return userapp;
	}

	public static void setUserapp(String userapp) {
		SysConfig.userapp = userapp;
	}

	public static String getUserpc() {
		return userpc;
	}

	public static void setUserpc(String userpc) {
		SysConfig.userpc = userpc;
	}

    public static String getServiceFeeUrl()
    {
    
        return serviceFeeUrl;
    }

    public static void setServiceFeeUrl(String serviceFeeUrl)
    {
    
        SysConfig.serviceFeeUrl = serviceFeeUrl;
    }

	public String getWorkOrderExpenseTopic() {
		return workOrderExpenseTopic;
	}

	public void setWorkOrderExpenseTopic(String workOrderExpenseTopic) {
		this.workOrderExpenseTopic = workOrderExpenseTopic;
	}
    
    
}