package com.ivan.aksionau.springBootRestAPI;

import com.ivan.aksionau.springBootRestAPI.utils.JsonTestDataManager;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BaseConfiguration {

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public JsonTestDataManager manager() {
        return new JsonTestDataManager();
    }
}
