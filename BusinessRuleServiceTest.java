package service;

import com.order.businessrule.model.Payment;
import com.order.businessrule.model.PaymentType;
import com.order.businessrule.service.BusinessRule;
import com.order.businessrule.service.BusinessRuleService;
import com.order.businessrule.util.BusinessRuleUtilities;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BusinessRuleServiceTest {

    private BusinessRuleService businessRuleService;

    private Payment payment;

    @BeforeEach
    void setUp() {
        this.businessRuleService = new BusinessRuleService();
        this.payment = new Payment();
        payment.type = PaymentType.PHYSICAL_PRODUCT.name();
        payment.name = "Mobile";
    }

    @Test
    public void Should_Return_Payments() throws IOException {
        setUp();
        List<Payment> paymentList = businessRuleService.getPayments();
        Assert.assertEquals(5, paymentList.size());
    }

    @Test
    public void Should_Process_Payment_Physical_Product(){
        setUp();
        BusinessRule br  = businessRuleService.processPayment(payment);
        Assert.assertEquals("com.order.businessrule.service.PhysicalProductBR", br.getClass().getName());
    }

    @Test
    public void Should_Process_Payment_Book(){
        setUp();
        payment.type = PaymentType.BOOK.name();
        BusinessRule br  = businessRuleService.processPayment(payment);
        Assert.assertEquals("com.order.businessrule.service.BookBR", br.getClass().getName());
    }

    @Test
    public void Should_Process_Payment_Video(){
        setUp();
        payment.type = PaymentType.VIDEO.name();
        BusinessRule br  = businessRuleService.processPayment(payment);
        Assert.assertEquals("com.order.businessrule.service.VideoBR", br.getClass().getName());
    }

    @Test
    public void Should_Process_Payment_MemberShip(){
        setUp();
        payment.type = PaymentType.MEMBERSHIP.name();
        BusinessRule br  = businessRuleService.processPayment(payment);
        Assert.assertEquals("com.order.businessrule.service.MembershipBR", br.getClass().getName());
    }

}
