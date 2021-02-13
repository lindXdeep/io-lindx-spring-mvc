package io.lindx.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "io.lindx.mvc.controller")
public class AppConfig {
    
}
