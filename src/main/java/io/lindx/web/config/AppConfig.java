package io.lindx.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "io.lindx.web.controller")
@EnableWebMvc
public class AppConfig {
    
}
