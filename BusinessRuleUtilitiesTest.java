package com.order.businessrule.util;

import org.junit.Assert;
import org.junit.Test;

public class BusinessRuleUtilitiesTest {

    @Test
    public void testSendMail() {
        String message = BusinessRuleUtilities.sendMail();
        Assert.assertEquals("mail sent successfully", message);
    }

    @Test
    public void testGenerateCommission() {
        String message = BusinessRuleUtilities.sendMail();
        Assert.assertEquals("commision genrated successfully", message);
    }
}
