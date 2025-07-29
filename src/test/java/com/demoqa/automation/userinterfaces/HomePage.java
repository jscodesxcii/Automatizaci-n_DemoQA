package com.demoqa.automation.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://demoqa.com/") // URL base de la Home
public class HomePage extends PageObject {

    // Primer card (Elements) en la página principal
    public static final Target ELEMENTS_CARD = Target.the("Tarjeta Elements")
            .located(By.xpath("//div[@class='category-cards']/div[1]"));
}
