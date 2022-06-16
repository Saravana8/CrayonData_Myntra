package com.runnerclass;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/FeatureFiles", glue = {"com.stepdefinition"}, tags = "@Sanity", monochrome = true, plugin = {"pretty", "json:target/cucumber.json" })
public class TestRunnerClass extends AbstractTestNGCucumberTests {
 

}
