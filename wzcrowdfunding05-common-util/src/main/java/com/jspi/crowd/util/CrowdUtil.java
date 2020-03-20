package com.jspi.crowd.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @ Author     : wz
 * @ ClassName  : com.jspi.crowd.util.CrowdUtil
 * @ Date       ：Created in 2020/3/20 10:08
 * @ Description：
 * @ Modified By：判断是普通请求（页面）还是ajax请求
 **/
public class CrowdUtil {

    /**
     * 判断当前请求是否为ajax请求，是返回true
     * @param request
     * @return
     */
    public static boolean judgeRequestType(HttpServletRequest request){
        //1.获取请求消息头
        String acceptHeader = request.getHeader("Accept");
        String xRequestedHeader = request.getHeader("X-Requested-With");
        return (acceptHeader != null && acceptHeader.contains("application/json"))
                ||
                (xRequestedHeader != null && xRequestedHeader.equals("XMLHttpRequest"));
    }
}
