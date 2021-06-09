package com.order.businessrule.service;

import com.order.businessrule.model.Payment;

public interface BusinessRule {
    void executeBusinessRule(Payment payment);
}
