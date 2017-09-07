package com.pei.billinginquiry.controller;

import com.pei.billinginquiry.model.Hello;
import com.pei.billinginquiry.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
@RestController
@RequestMapping("/hello")
public class HelloController
{
    @Autowired
    private HelloService helloService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Hello getHelloWorld() {
        return helloService.getLastPolicy();
    }
}
