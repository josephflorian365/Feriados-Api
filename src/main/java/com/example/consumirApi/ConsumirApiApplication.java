package com.example.consumirApi;

import com.example.consumirApi.service.FeriadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumirApiApplication {


    @Autowired
    FeriadoService feriadoService;

    public static void main(String[] args) {
        SpringApplication.run(ConsumirApiApplication.class, args);
    }

    @Bean
    public void consumirApiAndSaveDatabase() {

        feriadoService.save();

    }

}
