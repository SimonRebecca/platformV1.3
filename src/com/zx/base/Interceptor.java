package com.zx.base;

import com.zx.util.WebUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器
 * Created by zhangxin on 2015-07-28.
 */
public class Interceptor implements HandlerInterceptor {

    private Logger logger = LogManager.getLogger();

    /**
     * 在目标方法之前被调用
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        //记录访问日志
        String StringDate = WebUtil.getStringDate();
        String ip = WebUtil.getRemoteHost(request);
        String requestUrl = request.getRequestURI();
        String info = StringDate + "\t\tzhangxin\t\t" + ip + "\t\t" + requestUrl;
        logger.info(info);
        return true;
    }

    /**
     * 在调用目标方法之后，渲染视图之前被调用
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在渲染视图之后被调用
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
