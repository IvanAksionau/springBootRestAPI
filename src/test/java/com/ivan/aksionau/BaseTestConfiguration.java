package com.ivan.aksionau;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Pay attention that bean defined into the {@link BaseTestConfiguration} class
 * should have the similar name definition like below:
 *
 * @Autowired private ObjectMapper mapper;
 */
@Configuration
@ComponentScan
public class BaseTestConfiguration {

    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper();
    }
}
