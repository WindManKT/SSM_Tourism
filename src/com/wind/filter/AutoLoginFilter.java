package com.wind.filter;

import com.wind.domain.User;
import com.wind.error.MsgException;
import com.wind.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

public class AutoLoginFilter implements Filter {
    private ApplicationContext applicationContext;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        //如果没用登录
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
       if (cookies!=null){
           for (Cookie c : cookies) {
               if ("autologin".equals(c.getName())){
                   cookie = c;
                   break;
               }
           }
       }
        if (cookie!=null){
            String[] values = cookie.getValue().split("#");
            String username = URLDecoder.decode(values[0],"utf-8");
            String password = values[1];
            UserService userService = (UserService) applicationContext.getBean("userService");
            try{
                User user = userService.loginUser(new User.createUser().setUsername(username).setPassword(password).createUser());
                request.getSession().setAttribute("user",user);
            }catch (MsgException msg){
            }
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
