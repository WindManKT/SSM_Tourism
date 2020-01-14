package com.wind.mapper;

import com.wind.domain.Comm;
import org.apache.ibatis.annotations.Param;

import java.lang.Double;
import java.util.List;

public interface OrderMapper {
    Double findMoney(String land);

    void addComm(Comm comm);

    List<Comm> findComm(@Param("uid") int uid);
}
