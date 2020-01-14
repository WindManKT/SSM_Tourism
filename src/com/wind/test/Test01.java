package com.wind.test;

import com.wind.domain.Comm;
import com.wind.domain.Info;
import com.wind.domain.User;
import com.wind.error.MsgException;
import com.wind.mapper.UserMapper;
import com.wind.service.InfoService;
import com.wind.service.OrderService;
import com.wind.utils.WebUtils;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {

    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        System.out.println(orderService);
        System.out.println(orderService.findMoney("马来西亚"));
        try {
            orderService.addComm(new Comm(0,"000","000","000",2,3,"000",1));
            System.out.println("ok");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test02(){

        System.out.println(WebUtils.isPrior("2019-12-19"));
    }




}
