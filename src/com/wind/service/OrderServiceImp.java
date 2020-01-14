package com.wind.service;

import com.wind.domain.Comm;
import com.wind.error.MsgException;
import com.wind.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImp implements OrderService{

    @Autowired
    OrderMapper orderMapper;

    @Override
    public Double findMoney(String land) {
        return orderMapper.findMoney(land);
    }

    @Override
    public void addComm(Comm comm) {
        try {
            orderMapper.addComm(comm);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new MsgException("服务器繁忙，请稍后重试");
        }
    }

    @Override
    public List<Comm> findComm(int uid) {
        return orderMapper.findComm(uid);
    }
}
