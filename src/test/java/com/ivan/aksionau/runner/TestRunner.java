package com.ivan.aksionau.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * In your Cucumber runner class, you need to specify the location of your hook class.
 * This can be done by using the glue attribute of the {@link CucumberOptions} annotation.
 * {@code @DataProvider(parallel = true)} annotation is used to run tests in parallel.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"json:target/cucumber.json", "pretty"},
//        tags = "@all",
        extraGlue = "src/test/steps",
        glue = "com.ea.springbasic.steps")
public class TestRunner {
}
