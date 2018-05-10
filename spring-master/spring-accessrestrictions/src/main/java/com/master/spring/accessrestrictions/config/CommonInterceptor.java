package com.master.spring.accessrestrictions.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by user on 2017/9/20.
 */
@Component
public class CommonInterceptor extends HandlerInterceptorAdapter {
    @Value("${ip.access.restrictions}")
    private Integer ip_access_restrictions;

    private final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);

    public Integer getIp_access_restrictions() {
        return ip_access_restrictions;
    }

    public void setIp_access_restrictions(Integer ip_access_restrictions) {
        this.ip_access_restrictions = ip_access_restrictions;
    }

    public  static  final  String  LAST_PAGE = "lastPage";
    /**
     * 在业务处理器处理请求之前被调用
     * 如果返回false
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
     *
     * 如果返回true
     *    执行下一个拦截器,直到所有的拦截器都执行完毕
     *    再执行被拦截的Controller
     *    
     *    从最后一个拦截器然后进入拦截器链,往回执行所有的postHandle()
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String remoteHost = request.getRemoteHost();
        System.out.println(remoteHost);
        boolean b = IPAccessRestrictions.clientIP.containsKey(remoteHost);
        if(b==true){
            Integer integer = IPAccessRestrictions.clientIP.get(remoteHost)+1;
            if(integer>ip_access_restrictions){
//                return false;
            }
            IPAccessRestrictions.clientIP.put(remoteHost,integer);
            System.out.println(integer);
        }else {
            IPAccessRestrictions.clientIP.put(remoteHost,1);
        }
        return true;

    }
    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     * 可在modelAndView中加入数据，比如当前时间
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }
    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
