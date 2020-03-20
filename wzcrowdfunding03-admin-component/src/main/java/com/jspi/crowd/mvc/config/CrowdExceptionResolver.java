package com.jspi.crowd.mvc.config;

import com.google.gson.Gson;
import com.jspi.crowd.constant.CrowdConstant;
import com.jspi.crowd.util.CrowdUtil;
import com.jspi.crowd.util.ResultEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author     : wz
 * @ ClassName  : CrowdExceptionResolver
 * @ Date       ：Created in 2020/3/20 10:56
 * @ Description：
 * @ Modified By：基于注解的异常处理
 **/
//@ControllerAdvice表示当前类是异常处理器类
@ControllerAdvice
public class CrowdExceptionResolver {

    /*@ExceptionHandler将一个具体的异常类型和一个方法关联起来*/
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolveNULLPointException(
            NullPointerException exception, //实际捕获的异常类型
            HttpServletRequest request,//当前请求对象
            HttpServletResponse response) throws IOException {//当前响应对象
       String viewName = "system-error";
        return resolveCommonException(exception,viewName,request,response);
    }

    private ModelAndView resolveCommonException(Exception exception,//异常对象
                                                String viewName,//普通请求异常要返回的页面
                                                HttpServletRequest request,//请求对象
                                                HttpServletResponse response) throws IOException {//响应对象

        //1.判断当前请求类型
        boolean requestType = CrowdUtil.judgeRequestType(request);
        if (requestType){
            //2.当前请求类型为ajax请求类型，创建ResultEntity对象接收
            ResultEntity<Object> failed = ResultEntity.failed(exception.getMessage());
            //3.将ResultEntity转换成json
            Gson gson = new Gson();
            String json = gson.toJson(failed);
            //4.将json字符串作为响应体返回给浏览器
            response.getWriter().write(json);

            return null;
        }
        //5.请求类型为普通请求，返回异常信息到错误响应页面
        ModelAndView modelAndView = new ModelAndView();
        //6.将异常对象存入模型
        modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION,exception);
        //7.添加对应的视图
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
