package com.order.businessrule.service;

import com.order.businessrule.model.Payment;
import com.order.businessrule.util.BusinessRuleUtilities;

public class PhysicalProductBR implements BusinessRule {

    @Override
    public void executeBusinessRule(Payment payment) {
        System.out.println("generate a packing slip for shipping");
        BusinessRuleUtilities.generateCommision();
    }
}
