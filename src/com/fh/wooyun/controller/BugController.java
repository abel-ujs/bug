/**    
 * 文件名：BugController.java    
 *    
 * 版本信息：    
 * 日期：2016-4-7    
 * Copyright lhong Corporation 2016     
 * 版权所有    
 *    
 */
package com.fh.wooyun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fh.wooyun.service.BugService;

/**
 * @todo:
 * @author：lhong
 * @time:下午2:41:39
 * @version
 * 
 */
@Controller
public class BugController {

    @Autowired
    private BugService bs;

    @RequestMapping("getList.do")
    @ResponseBody
    public String getList(String key, String num, String size) {
        return bs.getListString(key, num, size);
    }

    @RequestMapping("getOne.do")
    @ResponseBody
    public String getOne(String id) {
        return bs.getBug(id);
    }
    /**
     * main()
     * 
     * @time: 2016-4-7 下午2:41:39
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
