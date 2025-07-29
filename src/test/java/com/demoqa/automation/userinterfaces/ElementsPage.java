package com.demoqa.automation.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ElementsPage extends PageObject {

    public static final Target TEXT_BOX_OPTION = Target.the("Opción Text Box")
            .located(By.xpath("//span[normalize-space()='Text Box']"));
}
