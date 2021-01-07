package com.wh.mas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.wh.mas"})
@MapperScan("com.wh.mas.*") //扫描的mapper
public class MasServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasServiceApplication.class, args);
    }

}
