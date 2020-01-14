package com.wind.controller;

import com.wind.domain.Comm;
import com.wind.domain.User;
import com.wind.error.MsgException;
import com.wind.service.OrderService;
import com.wind.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单模板
 */
@Controller
@RequestMapping("Order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("page.action")
    public String page(String land, HttpSession session, HttpServletRequest request){
        if (session.getAttribute("user")==null){
            session.setAttribute("login","login");
            return "forward:/login.action";
        }
        request.setAttribute("land",land);
        return "forward:/booking.action";
    }




    @RequestMapping("Commander.action")
    public String Commander(@Valid Comm comm, Errors errors, Model model,HttpSession session){
        if (!WebUtils.isMobile(comm.getPhone())){
            model.addAttribute("msg","⚠手机格式错误");
            return "forward:/booking.action";
        }

        if (errors.hasErrors()){
            List<ObjectError> allErrors = errors.getAllErrors();
            StringBuilder msg = new StringBuilder();
            for (ObjectError allError : allErrors) {
                msg.append("⚠" + allError.getDefaultMessage() + "<br>");
            }
            model.addAttribute("msg",msg.toString());
            return "forward:/booking.action";
        }

        if (WebUtils.isPrior(comm.getDate())){
            model.addAttribute("msg","⚠请选择有效的时间");
            return "forward:/booking.action";
        }

        Double money = orderService.findMoney(comm.getLand());

        if (money==null) {
            model.addAttribute("msg","⚠查无此地点");
            return "forward:/booking.action";
        }

        try{
            User user =(User)session.getAttribute("user");
            if (user!=null) {
                comm.setUid(user.getId());
                orderService.addComm(comm);
            }else {
                model.addAttribute("msg","⚠服务器繁忙，请稍后重试");
                return "forward:/booking.action";
            }
        }catch (MsgException msg){
            model.addAttribute("msg","⚠"+msg.getMessage());
            return "forward:/booking.action";
        }

        session.setAttribute("index","预定成功，本次消费金额预计为:"+money+"元，旅行开始时间为："+comm.getDate()+",地点为："+comm.getLand()+",您的旅行人数为："+(comm.getAdults()+comm.getChild())+ "人！");
        return "redirect:/index.action";
    }



}
