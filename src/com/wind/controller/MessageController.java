package com.wind.controller;

import com.wind.domain.Info;
import com.wind.domain.User;
import com.wind.error.MsgException;
import com.wind.service.InfoService;
import com.wind.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("message")
public class MessageController {
    @Autowired
    InfoService infoService;

    @RequestMapping("contact.action")
    public String contact(Model model,HttpSession session, String phone, String message){
        if (!WebUtils.isMobile(phone)){
            model.addAttribute("msg","⚠手机号格式错误");
            return "forward:/contact.action";
        }
        User user= (User)session.getAttribute("user");
        Info info = new Info(0,phone,message,user.getId());
        try {
            infoService.addInfo(info);
        }catch (MsgException msg){
            model.addAttribute("msg","⚠"+msg.getMessage());
            return "forward:/contact.action";
        }
        session.setAttribute("index","提交成功，感谢您的反馈");
        return "redirect:/index.action";
    }




}
