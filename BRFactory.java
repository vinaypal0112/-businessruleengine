package com.order.businessrule.service;

import com.order.businessrule.model.PaymentType;

public class BRFactory {

    public BusinessRule getBR(String paymentType) {
        if (paymentType == null) {
            return null;
        }
        if (PaymentType.PHYSICAL_PRODUCT.name().equals(paymentType)) {
            return new PhysicalProductBR();

        } else if (PaymentType.BOOK.name().equals(paymentType)) {
            return new BookBR();

        } else if (PaymentType.MEMBERSHIP.name().equals(paymentType)) {
            return new MembershipBR();
        } else if (PaymentType.MEMBERSHIP_UPGRADE.name().equals(paymentType)) {
            return new MembershipBR();
        } else if (PaymentType.VIDEO.name().equals(paymentType)) {
            return new VideoBR();
        }

        return null;
    }
}
