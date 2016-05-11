/**    
 * 文件名：BugService.java    
 *    
 * 版本信息：    
 * 日期：2016-4-7    
 * Copyright lhong Corporation 2016     
 * 版权所有    
 *    
 */
package com.fh.wooyun.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.fh.wooyun.dao.BugDao;
import com.fh.wooyun.entity.Bug;
import com.fh.wooyun.utils.TimeUtils;

/**    
 * @todo:      
 * @author：lhong    
 * @time:下午2:37:45            
 * @version     
 *     
 */
@Service
public class BugService {
    
    @Autowired 
    private BugDao bugDao;
    
    public String getListString(String key,String num,String size){
        Map<String,String> data = new HashMap<String,String>();
        List<Bug> list = bugDao.getList(key, Integer.valueOf(num), Integer.valueOf(size));
        for(Bug b:list){
           String time = b.getTimeinfo();
           if(StringUtils.isNotBlank(time)){
               long timeInt = Long.parseLong(time);
               String formatString = TimeUtils.convertToString(new Date(timeInt*1000), "yyyy-MM-dd hh:mm:ss");
               b.setTimeinfo(formatString);
           }
        }
        data.put("total",String.valueOf(bugDao.getSize(key)));
        data.put("list", JSON.toJSONString(list));
        data.put("num", num);
        data.put("size", size);
        return JSON.toJSONString(data);
    }
    public String getBug(String id){
        return JSON.toJSONString(bugDao.getById(id));
    }

    /**       
     * main() 
     * @time: 2016-4-7 下午2:37:45
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
