package com.thoughtworks.spike;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The @SpringBootApplication annotation is equivalent to using
 *  @Configuration,
 *  @EnableAutoConfiguration,
 *  @ComponentScan
 *  with their default attributes
 */
@SpringBootApplication     // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * No banner for SpringApplication when starting.
     */
//    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(DemoApplication.class);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);
//    }
}
