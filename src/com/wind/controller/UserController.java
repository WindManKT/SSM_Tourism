package com.wind.controller;

import com.wind.domain.User;
import com.wind.error.MsgException;
import com.wind.service.UserService;
import com.wind.utils.GraphicHelper;
import com.wind.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import javax.validation.Valid;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("regist.action")
    public String regist(@Valid User user,Errors errors,HttpServletRequest request,HttpServletResponse response,HttpSession session,String password2,String vcode) throws UnsupportedEncodingException {
        if (session.getAttribute("code")!=null&&vcode!=null&&!session.getAttribute("code").equals(vcode)){
            request.setAttribute("msg","⚠验证码错误");
            return "forward:/regist.action";
        }
        if (password2!=null && user.getPassword()!=null && !user.getPassword().equals(password2)){
            request.setAttribute("msg","⚠两次密码输入不一致");
            return "forward:/regist.action";
        }
        if (errors.hasErrors()){
            List<ObjectError> allErrors = errors.getAllErrors();
            StringBuilder msg = new StringBuilder();
            for (ObjectError allError : allErrors) {
                msg.append("⚠" + allError.getDefaultMessage() + "<br>");
            }
            request.setAttribute("msg",msg.toString());
            return "forward:/regist.action";
        }

        try {
            user.setPassword(MD5Utils.md5(user.getPassword()));
            userService.regist(user);
            session.setAttribute("user",user);
            Cookie cookie = new Cookie("autologin",  URLEncoder.encode(user.getUsername(),"utf-8") + "#" + user.getPassword());
            cookie.setMaxAge(60*60*24*30);
            cookie.setPath(request.getContextPath() + "/");
            response.addCookie(cookie);
            session.setAttribute("index","注册成功，已为您自动登录");
            return "redirect:/index.action";
        } catch (MsgException e) {
            request.setAttribute("msg","⚠" + e.getMessage());
            return "forward:/regist.action";
        }
    }

    @RequestMapping("login.action")
    public String login(User user, HttpSession session, Model model,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        user.setPassword(MD5Utils.md5(user.getPassword()));
        try{
            user =  userService.loginUser(user);
            session.setAttribute("user",user);
            Cookie cookie = new Cookie("autologin",  URLEncoder.encode(user.getUsername(),"utf-8") + "#" + user.getPassword());
            cookie.setMaxAge(60*60*24*30);
            cookie.setPath(request.getContextPath() + "/");
            response.addCookie(cookie);
            session.setAttribute("index","登录成功");
            return "redirect:/index.action";
        }catch (MsgException  msg){
            model.addAttribute("msg","⚠"+msg.getMessage());
            return "forward:/login.action";
        }
    }

    @RequestMapping("Verify.action")
    public void Verify(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.setDateHeader("Expires",-1);
            response.setHeader("pragma","no-cache");
            response.setHeader("cache-control","nocache");
            HttpSession session = request.getSession();
            final int width = 300; // 图片宽度
            final int height = 52; // 图片高度
            final String imgType = "jpeg"; // 指定图片格式 (不是指MIME类型)
            final OutputStream output = response.getOutputStream(); // 获得可以向客户端返回图片的输出流
            String code = GraphicHelper.create(width, height, imgType, output);
            session.setAttribute("code", code);
    }

    @RequestMapping("/loginOut.action")
    public String loginOut(HttpSession session,HttpServletResponse response,HttpServletRequest request){
        session.invalidate();
        Cookie cookie = new Cookie("autologin","");
        cookie.setMaxAge(0);
        cookie.setPath(request.getContextPath() + "/");
        response.addCookie(cookie);
        return "redirect:/index.action";
    }


}
