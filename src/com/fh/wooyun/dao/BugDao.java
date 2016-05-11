/**    
 * 文件名：BugDao.java    
 *    
 * 版本信息：    
 * 日期：2016-4-7    
 * Copyright lhong Corporation 2016     
 * 版权所有    
 *    
 */
package com.fh.wooyun.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.fh.wooyun.BaseDAO;
import com.fh.wooyun.entity.Bug;

/**    
 * @todo:      
 * @author：lhong    
 * @time:下午2:10:07            
 * @version     
 *     
 */
@Repository
public class BugDao extends BaseDAO {
    
    private static String getById = "select * from bugs where id=? ";
    private static String getList = "select * from bugs ";
    private static String getSize="select count(*) from bugs";
    private static String add = "insert into bugs values(?,?,?,?,?,?,?)";
    public Bug getById(String id){
        return this.dbHander.queryForBean(Bug.class,getById , new Object[]{id});
    }
    public List<Bug> getList(String key,int num,int size){
        num=num-1;
        if(num<0) num=0;
        StringBuilder sb = new StringBuilder(getList);
        if(StringUtils.isNotBlank(key)){
            sb.append(" where bugtitle like ? order by timeinfo desc limit ?,? ");
            return this.dbHander.queryForList(Bug.class, sb.toString(),new Object[]{"%"+key+"%",num,size});
        }else{
            sb.append(" order by timeinfo desc limit ?,? ");
            return this.dbHander.queryForList(Bug.class, sb.toString(),new Object[]{num*size,size});
        }
    }
    public int getSize(String key){
        if(StringUtils.isNotBlank(key)){
            StringBuilder sb = new StringBuilder(getSize);
            sb.append(" where bugtitle like ?");
            return this.dbHander.queryForInteger(sb.toString(), new Object[]{"%"+key+"%"});
        }
        return this.dbHander.queryForInteger(getSize);
    }
    public void add(Map<String,String> map){
        this.dbHander.execute(add,new Object[]{map.get("id"),map.get("bugtitle"),
                map.get("harmlevel"),map.get("whitehat_rank"),
                map.get("description"),map.get("content"),
                map.get("timeinfo")});
    }
    public boolean exsit(String id){
        Integer flag = this.dbHander.queryForInteger("select 1 from bugs where id= ? ", new Object[]{id});
        if(null==flag) return false;
        else return true;
    }
    
    

    /**       
     * main() 
     * @time: 2016-4-7 下午2:10:07
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
