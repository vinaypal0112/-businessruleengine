package com.order.businessrule.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.businessrule.BusinessRuleEngineApplication;
import com.order.businessrule.model.Payment;
import com.order.businessrule.model.PaymentType;
import com.order.businessrule.model.Payments;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

public class BusinessRuleService {

    private final String Payments_File_URL = "file:C:\\\\project\\\\businessruleengine\\\\src\\\\main\\\\resources\\\\inventory\\\\payment.json";


    BRFactory brFactory;

    private Logger logger
            = Logger.getLogger(
            BusinessRuleEngineApplication.class.getName());

    public List<Payment> getPayments() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        Payments payments = objectMapper.readValue(new URL(Payments_File_URL), Payments.class);
        return payments.getPayments();
    }

    public BusinessRule processPayment(Payment payment){
        brFactory = new BRFactory();
        BusinessRule br = brFactory.getBR(payment.type);
        br.executeBusinessRule(payment);
        return br; // FOr UnitTesting
    }

}
