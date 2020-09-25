package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommenResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/savePayment")
    public CommenResult savePayment(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if (result > 0){
            return new CommenResult(200,"插入成功",result);
        }else{
            return new CommenResult(-1,"插入失败",null);
        }
    }

    @GetMapping("/payment/getPaymentById/{id}")
    public CommenResult getPaymentById(@PathVariable("id") Integer id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("插入数据");
        if (Objects.isNull(result)){
            return new CommenResult(-1,"无ID为{}的数据"+id,null);
        }else {
            return new CommenResult(200,"查询成功",result);
        }
    }

}
