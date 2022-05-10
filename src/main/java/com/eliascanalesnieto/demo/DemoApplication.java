package com.eliascanalesnieto.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.eliascanalesnieto.demo.controller",
		"com.eliascanalesnieto.demo.service",
		"com.eliascanalesnieto.demo.repository",
		"com.eliascanalesnieto.demo.mapper",
        "com.eliascanalesnieto.demo.exception",
})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
