package com.ntndev.tmdtbasic;

import com.ntndev.tmdtbasic.services.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TmdtBasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmdtBasicApplication.class, args);
    }


    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.init();
        };
    }
}
