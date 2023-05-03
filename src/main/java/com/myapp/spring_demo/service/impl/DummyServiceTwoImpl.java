package com.myapp.spring_demo.service.impl;

import com.myapp.spring_demo.adapter.IExternalServiceAdapter;

public class DummyServiceTwoImpl implements IExternalServiceAdapter {

    @Override
    public String execute() {
        return "execited by : " + this.getClass().getName();
    }
}