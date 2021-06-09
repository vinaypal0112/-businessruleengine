package com.order.businessrule.service;

import com.order.businessrule.model.Payment;
import com.order.businessrule.model.PaymentType;
import com.order.businessrule.util.BusinessRuleUtilities;

public class MembershipBR implements BusinessRule {

    @Override
    public void executeBusinessRule(Payment payment) {
        if(PaymentType.MEMBERSHIP.name().equals(payment.type)){
            System.out.println("activate that membership");
        }else if(PaymentType.MEMBERSHIP_UPGRADE.name().equals(payment.type)){
            System.out.println("apply the upgrade");
        }
        BusinessRuleUtilities.sendMail();
    }
}
