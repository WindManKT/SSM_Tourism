package com.wind.service;

import com.wind.domain.Comm;

import java.util.List;

public interface OrderService {

    Double findMoney(String land);

    void addComm(Comm comm);

    List<Comm> findComm(int uid);
}
