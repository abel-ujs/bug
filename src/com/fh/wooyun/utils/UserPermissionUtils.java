package com.fh.wooyun.utils;


import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.Properties;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

/**    
 * @todo:      
 * @author：  
 * @time:下午4:15:08            
 * @version     
 *     
 */
public class UserPermissionUtils
{
   private static final String CONFIG_FILE = "users.properties";
   static Properties pro = null;
   
   static
   {
	   pro = new Properties();
	   try
		{
			pro.load(UserPermissionUtils.class.getClassLoader().getResourceAsStream(CONFIG_FILE));
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
   }
   
   /**       
 * getProperty() 
 * @time: 2015-8-17 下午4:40:09
 * @author:   
 * @param       
 * @return   
 * @Exception 
 * @since  　   
*/
public static String getProperty(String key)
   {
        
	   return pro.getProperty(key);
   }

public static boolean hasPermission(ServletRequest request){
    String user = getUkey((HttpServletRequest)request);
    if(StringUtils.isBlank(user)) return false;
    return pro.containsKey(user)&& ("1".equals(pro.get(user)));
}

public static String getUkey(HttpServletRequest request) 
{
    String keyinfo = request.getHeader("req_cert_subject");
    //com.iknow.cas.client.Credential credential = com.iknow.cas.client.AssertionHelper.getCredential();
    //String keyinfo=credential.getUserkey(); // 获取SSL证书中的CN名称
    String keyname = null;
    if (StringUtils.isNotEmpty(keyinfo))
    {
        keyname = StringUtils.substringBetween(keyinfo, "CN=", "/");
        //keyname=keyinfo;
    } else 
    {
        X509Certificate[] certs = (X509Certificate[]) request
                .getAttribute("javax.servlet.request.X509Certificate");
        if (!ArrayUtils.isEmpty(certs)) 
        {
            keyname = StringUtils.substringBetween(certs[0].getSubjectDN().toString(), "CN=", ",");
        }
    }
    return StringUtils.trimToEmpty(keyname);
}
   
   public static void main(String[] args)
{
}
}
