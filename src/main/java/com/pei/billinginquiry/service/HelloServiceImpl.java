package com.pei.billinginquiry.service;

import com.pei.billinginquiry.dao.HelloDAO;
import com.pei.billinginquiry.model.Hello;
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
