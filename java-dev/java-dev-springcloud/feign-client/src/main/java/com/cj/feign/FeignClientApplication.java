package com.cj.feign;

import com.cj.feign.clients.JSONPlaceHolderClient;
import com.cj.feign.config.FeignConfiguration;
import com.cj.feign.pojo.Post;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
//@EnableFeignClients(defaultConfiguration = FeignConfiguration.class)
//@EnableFeignClients(basePackages = "com.cj.feign", defaultConfiguration = FeignConfiguration.class)
@EnableFeignClients(clients = {JSONPlaceHolderClient.class}, defaultConfiguration = FeignConfiguration.class)

public class FeignClientApplication {



    public static void main(String[] args) {
        SpringApplication.run(FeignClientApplication.class, args);
    }

    @RestController
    @RequestMapping("/feign")
    public class FeignClientController {
        @Resource
        private JSONPlaceHolderClient client;
        @GetMapping("/get")
        public List<Post> get() {
            return client.getPosts();
        }
    }

}
