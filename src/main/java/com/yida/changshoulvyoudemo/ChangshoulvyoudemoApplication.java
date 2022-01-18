package com.yida.changshoulvyoudemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.yida.changshoulvyoudemo.mapper")//扫描通用mapper
public class ChangshoulvyoudemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChangshoulvyoudemoApplication.class, args);
    }

}
