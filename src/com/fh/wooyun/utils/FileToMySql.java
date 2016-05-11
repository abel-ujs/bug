/**    
 * 文件名：FileToMySql.java    
 *    
 * 版本信息：    
 * 日期：2016-4-8    
 * Copyright lhong Corporation 2016     
 * 版权所有    
 *    
 */
package com.fh.wooyun.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fh.wooyun.BaseDAO;
import com.fh.wooyun.dao.BugDao;

/**    
 * @todo:      
 * @author：lhong    
 * @time:上午10:18:05            
 * @version     
 *     
 */
public class FileToMySql extends BaseDAO{
    
    private static final Log logger = LogFactory.getLog(FileToMySql.class);
    
    public static URLDecoder ud = new URLDecoder();
    public static BugDao bd = new BugDao();
    
    public void processFileToMySql(String path){
        Collection<File> scanPath = scanPath(path);
        int i=0;
        for(File f:scanPath){
            try {
                processFile(f);
                i++;
                logger.info((i*100.0)/scanPath.size()+"%"+"--"+f.getName());
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    private Collection<File> scanPath(String path){
        if(StringUtils.isBlank(path)) return null;
        File f = new File(path);
        if(f.isDirectory()){
            return FileUtils.listFiles(f,new String[]{"bcp"}, true);
        }
        return null;
    }
    private void processFile(File file) throws IOException{
        if(null==file){
            return ;
        }
        LineIterator iterator = FileUtils.lineIterator(file,"utf-8");
        while(iterator.hasNext()){
            String line = iterator.next().toString();
            String[] split = line.split("\t");
            String time = split[split.length-1];
            String contents= split[split.length-4];
            Map<String, String> map = processLine(contents);
            map.put("timeinfo", time);
            if(!bd.exsit(map.get("id"))){
                bd.add(map);
            }
        }
    }
    private Map<String,String> processLine(String line) throws UnsupportedEncodingException{
        Map<String,String> map = new HashMap<String,String>();
        String[] split = line.split("&");
        for(String s:split){
            String[] items = s.split("=");
            if(items.length>1){
                System.out.println(items[1]);
                String _tmp = FileToMySql.ud.decode(items[1].replaceAll("%(?![0-9a-fA-F]{2})", ""),"utf-8");
                if("bugtitle".equals(items[0])) {
                    map.put("bugtitle", _tmp);
                }
                if("title".equals(items[0])) {
                    map.put("bugtitle", _tmp);
                    map.put("id",MD5Utils.digest(_tmp));
                }
                
                if("harmlevel".equals(items[0])) map.put("harmlevel", _tmp);
                if("buglevel".equals(items[0])) map.put("harmlevel", _tmp);
                
                if("whitehat_rank".equals(items[0])) map.put("whitehat_rank", _tmp);
                if("rank".equals(items[0])) map.put("whitehat_rank", _tmp);
                
                if("description".equals(items[0])) map.put("description", _tmp);
                if("content".equals(items[0])) map.put("content", _tmp.replaceAll("(?<=<img src=\")(/upload)", "www.wooyun.org"+"$1"));
            }
        }
        map.put("id", MD5Utils.digest(map.get("bugtitle")+map.get("harmlevel")+map.get("buglevel")+map.get("whitehat_rank")));
        return map;
    }

    /**       
     * main() 
     * @time: 2016-4-8 上午10:18:05
     * @author:lhong       
     * @param       
     * @return   
     * @Exception 
     * @since  　   
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String path = args[0];
        if(StringUtils.isBlank(path)){
            logger.error("path is null");
            return;
        }
        FileToMySql fileToMySql = new FileToMySql();
        System.out.println(fileToMySql.isConnection());
        fileToMySql.processFileToMySql(path);
    }

}
