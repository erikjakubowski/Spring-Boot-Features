package com.spring;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *
 * Driver harness class for Cucumber Tests
 *
 */

//JUnit runner use Cucumber
@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty", "html:build/reports/cucumber"},
        features = "src/test/resources/com.cuc",
        monochrome = true)
public class RunningCucumberTests {
}

