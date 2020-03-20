package com.jspi.crowd.mvc.handler;

import com.jspi.crowd.service.api.AdminService;
import com.jspi.crowd.util.CrowdUtil;
import com.jspi.crowd.util.ResultEntity;
import entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;



/**
 * @ Author     : wz
 * @ ClassName  : TestHandler
 * @ Date       ：Created in 2020/3/19 10:15
 * @ Description：
 * @ Modified By：
 **/
@Controller
public class TestHandler {

    @Autowired
    private AdminService adminService;

    Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @RequestMapping("test/ssm")
    public String testSsm(ModelMap modelMap, HttpServletRequest request){
        boolean requestType = CrowdUtil.judgeRequestType(request);
        logger.info("requestType:"+requestType+"-----------------------------------------");
        List<Admin> adminList = adminService.getAll();
        modelMap.addAttribute("adminList",adminList);
/*
        System.out.println(10/0);
*/
        String a = null;
        System.out.println(a.length());
        return "target";
    }
    @ResponseBody
    @RequestMapping("send/array")
    public String array(@RequestBody List<Integer> array){
        for (Integer number:array) {
            logger.info("number="+number);
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("test/json")
    public ResultEntity<Admin> testJson(@RequestBody Admin admin,HttpServletRequest request){
        boolean judgeRequestType = CrowdUtil.judgeRequestType(request);
        logger.info("judgeRequestType:"+judgeRequestType+"----------------------");
        String a = null;
        System.out.println(a.length());
        return ResultEntity.successWithData(admin);
    }
}
