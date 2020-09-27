package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommenResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@PropertySource("classpath:constant.properties")
public class OrderConsulController {
    @Value("${RESTTEMPLATE_URL}")
    private String RESTTEMPLATE_URL;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommenResult create(Payment payment){
        return restTemplate.postForObject(RESTTEMPLATE_URL+"payment/savePayment",payment,CommenResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommenResult getPaymentById(@PathVariable("id")Integer id){
        return restTemplate.getForObject(RESTTEMPLATE_URL+"payment/getPaymentById/"+id,CommenResult.class);
    }

}
