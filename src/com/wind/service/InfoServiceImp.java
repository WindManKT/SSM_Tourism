package com.wind.service;

import com.wind.domain.Info;
import com.wind.error.MsgException;
import com.wind.mapper.InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("infoService")
public class InfoServiceImp implements InfoService {

    @Autowired
    InfoMapper infoMapper;

    @Override
    public void addInfo(Info info) {
        try{
            infoMapper.addInfo(info);
        }catch (Exception e){
            throw new MsgException("⚠错误，系统异常请稍后重试");
        }
    }
}
