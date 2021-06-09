package com.order.businessrule;

import com.order.businessrule.model.Payment;
import com.order.businessrule.service.BusinessRuleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class BusinessRuleEngineApplication {

    public static void main(String[] args)  {
        SpringApplication.run(BusinessRuleEngineApplication.class, args);
        BusinessRuleService service = new BusinessRuleService();
        Logger logger
                = Logger.getLogger(
                BusinessRuleEngineApplication.class.getName());
        try {
            /*
                Get payments
             */
            List<Payment> payments = service.getPayments();
            if(payments != null){
                payments.forEach(payment -> {
                    service.processPayment(payment);
                });
            }



        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

}
