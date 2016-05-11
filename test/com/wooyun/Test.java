/**    
 * 文件名：Test.java    
 *    
 * 版本信息：    
 * 日期：2016-4-7    
 * Copyright lhong Corporation 2016     
 * 版权所有    
 *    
 */
package com.wooyun;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.regex.Pattern;

import com.fh.wooyun.BaseDAO;
import com.fh.wooyun.dao.BugDao;
import com.fh.wooyun.utils.TimeUtils;

/**    
 * @todo:      
 * @author：lhong    
 * @time:上午11:09:10            
 * @version     
 *     
 */
public class Test extends BaseDAO{

    /**       
     * main() 
     * @time: 2016-4-7 上午11:09:10
     * @author:lhong       
     * @param       
     * @return   
     * @throws UnsupportedEncodingException 
     * @Exception 
     * @since  　   
     */
    public static void main(String[] args){
        // TODO Auto-generated method stub
//        String s = "ssssssss";
//        String s2 = "绕d过腾讯云waf 搞定某B轮投资公司影响近百家医院&";
//        System.out.println(s.hashCode());
//        System.out.println(s2.hashCode());
//       BaseDAO baseDAO = new BaseDAO();
//       System.out.println(baseDAO.isConnection());
//            String test ="invite=1&email=L0oktar%40163.com&corptype=1&area=1&corpname=%E4%B8%AD%E5%9B%BD%E5%A4%AA%E4%BB%93%E6%B8%AF&corpid=0&bugtype=3&other_bugtype=&bug_subtype=12&bugtitle=%E4%B8%AD%E5%9B%BD%E5%A4%AA%E4%BB%93%E6%B8%AF%E7%AE%A1%E7%90%86%E5%A7%94%E5%91%98%E4%BC%9A%E6%9F%90%E5%A4%84sql%E6%B3%A8%E5%85%A5&harmlevel=2&whitehat_rank=5&description=%E4%B8%AD%E5%9B%BD%E5%A4%AA%E4%BB%93%E6%B8%AF%E7%AE%A1%E7%90%86%E5%A7%94%E5%91%98%E4%BC%9A%E6%9F%90%E5%A4%84sql%E6%B3%A8%E5%85%A5&content=%E6%B3%A8%E5%85%A5%E7%82%B9%EF%BC%9A%0D%0A%3Ccode%3Ehttp%3A%2F%2Fwww.tcport.gov.cn%2FShowNews.aspx%3FType%3DNews%26Guid%3Da233b8d3-f0f1-4cb2-a192-099d78b0fce2%3C%2Fcode%3E%0D%0A%0D%0A&poc=%3Cimg+src%3D%22%2Fupload%2F201604%2F0215395040fd5c0f7667d83c1c246777b6e2b7ce.png%22+alt%3D%221.1.png%22+%2F%3E%0D%0A%E6%95%B0%E6%8D%AE%E5%BA%93%0D%0A%3Cimg+src%3D%22%2Fupload%2F201604%2F021542378481a85799e73845d4ccbf14def44b76.png%22+alt%3D%222.2.png%22+%2F%3E%0D%0A%E5%BD%93%E5%89%8D%E6%95%B0%E6%8D%AE%E5%BA%93%E7%9A%84%E8%A1%A8%0D%0A%3Ccode%3EDatabase%3A+GWHWEB%0D%0A%5B20+tables%5D%0D%0A%2B------------------------%2B%0D%0A%7C+GWH_Admin++++++++++++++%7C%0D%0A%7C+GWH_GovOpen++++++++++++%7C%0D%0A%7C+GWH_InfoList+++++++++++%7C%0D%0A%7C+GWH_LINK+++++++++++++++%7C%0D%0A%7C+GWH_LeadMail+++++++++++%7C%0D%0A%7C+GWH_Notes++++++++++++++%7C%0D%0A%7C+GWH_OnlineSurveyDetail+%7C%0D%0A";
            // %40 - @
//            System.out.println(URLDecoder.decode(test.replaceAll("%(?!.*(\\d|\\w){2})", ""), "utf-8"));
//            System.out.println(TimeUtils.convertToString(new Date(), "yyyy-MM-dd hh:mm:ss"));
//            System.out.println(new Date().getTime());
//        String test = "<img src=\"/upload/201603/30221855d8acb993281e9965a899b50bbf3a4487.png\" alt=\"3G6Q`RI%WR4XL%K0U1QJQ%4.png\" />[img src=\"http://static.wooyun.org/upload/image/2016040110155161539.png\" alt=\"1.png\"/] \"sss\"dfdfa\"";
//        System.out.println(test.replaceAll("(?<=<img src=\")(/upload)", "www.wooyun.org"+"$1"));
//        String test = "新房经纪人APP获取大量客户信息外加给任意经纪人（添加、修改，删除）报备客户";
//        System.out.println(URLEncoder.encode(test, "utf-8"));
        Test test = new Test();
        Integer queryForInteger = test.dbHander.queryForInteger("select 1 from bugs where id=1");
        Integer queryForInteger2 = test.dbHander.queryForInteger("select 1 from bugs where id=2");
        Integer queryForInteger3 = test.dbHander.queryForInteger("select 1 from bugs where id=3");
        System.out.println(queryForInteger);
        System.out.println(queryForInteger2);
        System.out.println(queryForInteger3);
        
    }

}
