/**    
 * 文件名：MD5Utils.java    
 *    
 * 版本信息：    
 * 日期：2016-4-8    
 * Copyright lhong Corporation 2016     
 * 版权所有    
 *    
 */
package com.fh.wooyun.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;

import com.mchange.lang.ByteUtils;

/**    
 * @todo:      
 * @author：lhong    
 * @time:下午3:45:22            
 * @version     
 *     
 */
public class MD5Utils {
    
    public static String digest(String s){
        if(StringUtils.isBlank(s)) return "";
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] digestBytes = digest.digest(s.getBytes());
            return ByteUtils.toHexAscii(digestBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**       
     * main() 
     * @time: 2016-4-8 下午3:45:22
     * @author:lhong       
     * @param       
     * @return   
     * @Exception 
     * @since  　   
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(MD5Utils.digest("b"));
    }

}
