package com.ivan.aksionau;

import com.ivan.aksionau.utils.JsonTestDataManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Pay attention that bean defined into the {@link BaseTestConfiguration} class
 * should have the similar name definition like below:
 *
 * @Autowired
 * private JsonTestDataManager manager;
 */
@Configuration
@ComponentScan
public class BaseTestConfiguration {

    @Bean
    public JsonTestDataManager manager() {
        return new JsonTestDataManager();
    }
}
