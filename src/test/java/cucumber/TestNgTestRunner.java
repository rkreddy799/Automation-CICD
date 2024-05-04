package cucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber/TestNgTestRunner.java",glue="rahulsheetyacademy.stepDefinitions",
tags="Regression",monochrome=true,plugin ={"html:target/cucumber.html"})
public class TestNgTestRunner extends AbstractTestNGCucumberTests{

}

