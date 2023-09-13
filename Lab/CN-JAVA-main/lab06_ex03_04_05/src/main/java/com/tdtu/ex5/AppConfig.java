package com.tdtu.ex5;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.tdtu.lab06_ex005")
@PropertySource("products.properties")
public class AppConfig {
}
