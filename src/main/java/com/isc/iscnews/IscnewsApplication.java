package com.isc.iscnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IscnewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(IscnewsApplication.class, args);
    }

}
