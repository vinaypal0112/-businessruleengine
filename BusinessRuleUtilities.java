package com.order.businessrule.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BusinessRuleUtilities {
    public String sendMail(){
        System.out.println("send e-mail the owner and inform them of the activation/upgrade");
        return "mail sent successfully";
    }

    public String generateCommision(){
        System.out.println("generate a commission ");
        return "commision genrated successfully";
    }
}
