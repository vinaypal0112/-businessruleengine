package com.order.businessrule.service;

import com.order.businessrule.model.Payment;
import com.order.businessrule.util.BusinessRuleUtilities;

public class BookBR implements BusinessRule {

    @Override
    public void executeBusinessRule(Payment payment) {
        System.out.println("duplicate packing slip for the royalty department");
        BusinessRuleUtilities.generateCommision();
    }
}
