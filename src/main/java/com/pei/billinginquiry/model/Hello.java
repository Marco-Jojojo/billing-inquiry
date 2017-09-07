package com.pei.billinginquiry.model;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
public class Hello
{
    private String helloString;

    public Hello() {
    }

    public Hello(String helloString) {
        this.helloString = helloString;
    }

    public String getHelloString() {
        return helloString;
    }

    public void setHelloString(String helloString) {
        this.helloString = helloString;
    }

    @Override
    public String toString() {
        return "Hello{" + "helloString=" + helloString + '}';
    }
    
}
