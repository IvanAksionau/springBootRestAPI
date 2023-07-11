package com.ivan.aksionau;

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

}
