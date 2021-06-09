package com.order.businessrule.service;

import com.order.businessrule.model.Payment;

public class VideoBR implements BusinessRule {

    @Override
    public void executeBusinessRule(Payment payment) {
        System.out.println("add a free First Aid video to the packing slip");
    }
}
