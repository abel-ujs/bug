/**    
 * 文件名：GlabalIntercepter.java    
 *    
 * 版本信息：    
 * 日期：2016-4-9    
 * Copyright lhong Corporation 2016     
 * 版权所有    
 *    
 */
package com.fh.wooyun.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**    
 * @todo:      
 * @author：lhong    
 * @time:上午9:27:02            
 * @version     
 *     
 */
public class GlabalIntercepter extends HandlerInterceptorAdapter {

    private static Log log = LogFactory.getLog(GlabalIntercepter.class);
    /* (non-Javadoc)    
     * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)    
     */
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)    
     * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)    
     */
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

    }

    /* (non-Javadoc)    
     * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)    
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        boolean ukey = UserPermissionUtils.hasPermission(request);
        log.info("intercepter ,permission:"+ukey);
        if(!ukey){
            response.getWriter().print("该用户没有权限！");
            return false;
        }
        return true;
    }

    /**       
     * main() 
     * @time: 2016-4-9 上午9:27:02
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
