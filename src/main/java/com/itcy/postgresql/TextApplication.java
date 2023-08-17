package com.itcy.postgresql;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author 176
 */
@SpringBootApplication
@Slf4j

public class TextApplication {
    public static void main(String[] args) {
        SpringApplication.run(TextApplication.class,args);
    }

}
