package com.example.examclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import rpccommon.GrpcConfig;

@SpringBootApplication
@Import(GrpcConfig.class)
public class ExamClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamClientApplication.class, args);
    }

}
