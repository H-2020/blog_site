package com.intec.brussel.blogsite;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Blogsite API", version = "1.0", description = "Blogsite Api Information"))
public class BlogSiteApplication {

    public static void main(String[] args) {

        SpringApplication.run(BlogSiteApplication.class, args);
    }

}
