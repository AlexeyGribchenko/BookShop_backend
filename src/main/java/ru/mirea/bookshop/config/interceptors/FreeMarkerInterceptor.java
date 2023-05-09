package ru.mirea.bookshop.config.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class FreeMarkerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest aRequest,
            HttpServletResponse aResponse,
            Object aHandler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest aRequest,
            HttpServletResponse aResponse,
            Object aHandler,
            ModelAndView aModelAndView) throws Exception {
        if (aModelAndView != null) {
            aModelAndView.addObject(
                    "userAuth",
                    SecurityContextHolder.getContext().getAuthentication());
        }
    }

    @Override
    public void afterCompletion(
            HttpServletRequest aRequest,
            HttpServletResponse aResponse,
            Object aHandler,
            Exception aEx) throws Exception {
    }

}
