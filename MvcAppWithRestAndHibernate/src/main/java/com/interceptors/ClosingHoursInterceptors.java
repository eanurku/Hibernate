package com.interceptors;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ClosingHoursInterceptors  extends HandlerInterceptorAdapter {


    String END_TIME="23:59:00";
    String START_TIME="23:58:00";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        LocalDateTime localdatetime=LocalDateTime.now();
        if(localdatetime.toLocalTime().compareTo(LocalTime.parse(END_TIME))<0 && localdatetime.toLocalTime().compareTo(LocalTime.parse(START_TIME))>0){

            response.getWriter().write("website is closed between 10.00 pm to 11.59 pm");
            return  false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("post handle called :"+request.getRequestURI());

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("after completion called:"+request.getRequestURL());
    }
}
