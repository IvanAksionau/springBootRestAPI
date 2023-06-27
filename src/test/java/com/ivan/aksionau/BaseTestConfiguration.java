package com.ivan.aksionau;

import com.ivan.aksionau.utils.JsonReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Pay attention that bean defined into the class
 * should have the same name as bean defined in BaseTestConfiguration class:
 *
 * @Autowired
 * private JsonReader reader;
 */
@Configuration
@ComponentScan
public class BaseTestConfiguration {

    @Bean
    public JsonReader reader() {
        return new JsonReader();
    }
}
