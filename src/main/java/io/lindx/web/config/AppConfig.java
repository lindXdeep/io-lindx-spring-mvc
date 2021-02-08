package io.lindx.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "io.lindx.web.controller")
public class AppConfig {
    
}
