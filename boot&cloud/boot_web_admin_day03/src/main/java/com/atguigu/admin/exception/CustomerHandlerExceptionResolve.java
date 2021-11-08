package com.atguigu.admin.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@ClassName CustomerHandlerExceptionResolve
 *@Description  TODO
 *@Author hqb
 *@Date 2021/11/7 17:15
 *@Version 1.0
 */

/**
 * 定制错误处理逻辑
 * error/404.html error/5xxhtml;有精确的错误状态码页码就匹配精确，没有就找4xx.html 如果都没有就触发白页
 * @ControllerAdvice+@ExceptionHdler  处理全局异常，底层是ExceptionHandlerExceptionResolver支持的
 * @ResponseStatus + 自定义异常，底层是ResponseStatusExceptionResolver,把responsestatus主机的信息底层调用
 *  response.sendError(statusCode,resolveReason);tomcat 发送/error
 *
 */

@Order(value = Ordered.HIGHEST_PRECEDENCE) //优先级，数字越小优先级越高
@Component
public class CustomerHandlerExceptionResolve implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,


                                      Object handler, Exception ex) {

        try {
            response.sendError(511,"我喜欢的错误");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}

