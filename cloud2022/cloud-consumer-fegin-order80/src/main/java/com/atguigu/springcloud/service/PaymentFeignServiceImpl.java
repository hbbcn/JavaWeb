package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;


public class PaymentFeignServiceImpl implements  PaymentFeignService{
    @Override
    public CommonResult<Payment> getPaymentById(int id) {
        return null;
    }

    @Override
    public String paymentFeignTimeout() {
        return null;
    }
}
