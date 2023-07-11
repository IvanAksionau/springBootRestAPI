package com.ivan.aksionau.springBootRestAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivan.aksionau.springBootRestAPI.utils.JsonDataManager;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Pay attention that bean defined into the {@link BaseConfiguration} class
 * should have the similar name definition like below:
 *
 * @Autowired private ObjectMapper mapper;
 */
@Configuration
@ComponentScan
public class BaseConfiguration {

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public JsonDataManager manager() {
        return new JsonDataManager();
    }

    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper();
    }
}
