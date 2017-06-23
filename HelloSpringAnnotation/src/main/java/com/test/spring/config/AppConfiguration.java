package com.test.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.test.spring.lang.Language;
import com.test.spring.lang.impl.Vietnamese;

@Configuration
@ComponentScan({"com.test.spring.bean"})
public class AppConfiguration {
 
    @Bean(name ="language")
    public Language getLanguage() {
 
        return new Vietnamese();
    }
      
}
