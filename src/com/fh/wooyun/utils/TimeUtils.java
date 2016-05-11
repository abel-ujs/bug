/**    
 * 文件名：TimeUtils.java    
 *    
 * 版本信息：    
 * 日期：2016-4-8    
 * Copyright lhong Corporation 2016     
 * 版权所有    
 *    
 */
package com.fh.wooyun.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**    
 * @todo:      
 * @author：lhong    
 * @time:上午9:20:45            
 * @version     
 *     
 */
public class TimeUtils {
    
    public static String convertToString(Date date,String pattern){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**       
     * main() 
     * @time: 2016-4-8 上午9:20:45
     * @author:lhong       
     * @param       
     * @return   
     * @Exception 
     * @since  　   
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
