package com.company.minicodetest.lettercombination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class LetterCombinationApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(LetterCombinationApp.class, args);

    }
}
