package com.xxm.codeExtractor.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages="com.xxm.codeExtractor.config")
@EnableSwagger2
public class CodeExtractorApplication {

	public static void main(String[] args) {

		SpringApplication.run(CodeExtractorApplication.class, args);

	}

}
