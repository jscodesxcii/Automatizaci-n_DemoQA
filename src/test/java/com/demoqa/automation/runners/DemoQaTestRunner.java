package com.demoqa.automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.demoqa.automation.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class DemoQaTestRunner { }
