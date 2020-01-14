package com.wind.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wind.domain.Comm;
import com.wind.domain.User;
import com.wind.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@Controller
public class ForwardController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/{path}.action")
    public String forward(@PathVariable String path){
        return "forward:/WEB-INF/" + path + ".jsp";
    }

    @ResponseBody
    @RequestMapping(value = "/myComm.action",produces = "application/json;charset=utf-8")
    public ModelAndView myComm(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("forward:/WEB-INF/myComm.jsp");
        User user = (User)session.getAttribute("user");
        List<Comm> comms =  orderService.findComm(user.getId());
        modelAndView.addObject("comms",comms);
        return modelAndView;
    }
}
