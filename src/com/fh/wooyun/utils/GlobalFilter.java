/**    
 * 文件名：GlobalFilter.java    
 *    
 * 版本信息：    
 * 日期：2016-4-9    
 * Copyright lhong Corporation 2016     
 * 版权所有    
 *    
 */
package com.fh.wooyun.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**    
 * @todo:      
 * @author：lhong    
 * @time:上午10:07:10            
 * @version     
 *     
 */
public class GlobalFilter implements Filter {
    
    private static Log log = LogFactory.getLog(GlobalFilter.class);

    /* (non-Javadoc)    
     * @see javax.servlet.Filter#destroy()    
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)    
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)    
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        boolean ukey = UserPermissionUtils.hasPermission(request);
        log.info("intercepter ,permission:"+ukey);
        if(!ukey){
            response.getWriter().print("该用户没有权限！");
            return;
        }
        chain.doFilter(request, response);
    }

    /* (non-Javadoc)    
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)    
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

    /**       
     * main() 
     * @time: 2016-4-9 上午10:07:10
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
