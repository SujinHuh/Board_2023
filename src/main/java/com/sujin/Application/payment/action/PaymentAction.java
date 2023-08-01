package com.sujin.Application.payment.action;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PaymentAction {
    /***
     *
     get -> return string (page 이동)
     post -> return response (api 호출)
     */
    @GetMapping("/payment")
    public String payment(Model model) {

        return "payment/payment";
    }

}
