package com.demoqa.stepdefinitions;

import net.serenitybdd.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.steps.ScenarioActor;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ScrollSteps extends ScenarioActor {

    @Step("Desplazar la página hacia abajo")
    public void scrollDown() {
        WebDriver driver = getDriver();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Step("Desplazar la página hacia arriba")
    public void scrollUp() {
        WebDriver driver = getDriver();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
    }
}
