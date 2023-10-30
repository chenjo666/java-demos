package com.example.javadevspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cj.properties.SmsProperties;
import com.cj.service.SmsTemplate;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class JavaDevSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaDevSpringbootApplication.class, args);
    }

    @RestController
    @RequestMapping("/sms")
    public class SmsStarterController {
        @Resource
        private SmsTemplate smsTemplate;
        @Resource
        private SmsProperties smsProperties;

        @Resource
        private RedisTemplate<String, Object> redisTemplate;
        @GetMapping("/get")
        public String getNow() {
//            System.out.println(smsProperties);
//            String fromPhone = "15522834580";
//            String toPhone = "13820345839";
//            String content = "屮";
//            return smsTemplate.send(fromPhone,toPhone,content);

            redisTemplate.opsForValue().set("zja", 1);
            return "ok";
        }

    }
}

