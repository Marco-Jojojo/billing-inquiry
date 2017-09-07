package com.pei.billinginquiry.example.service;

import com.pei.billinginquiry.example.dao.HelloDAO;
import com.pei.billinginquiry.example.model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
@Service
public class HelloServiceImpl implements HelloService
{
    @Autowired
    private HelloDAO helloDAO;

    @Override
    public Hello getLastPolicy() {
        return helloDAO.getLastPolicy();
    }
    
}
