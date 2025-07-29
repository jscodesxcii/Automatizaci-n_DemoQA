package com.demoqa.automation.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://demoqa.com/")
public class HomePage extends PageObject {

    // Tarjeta Elements (la primera)
    public static final Target ELEMENTS_CARD = Target.the("Tarjeta Elements")
            .located(By.xpath("//div[@class='category-cards']/div[1]"));
}
