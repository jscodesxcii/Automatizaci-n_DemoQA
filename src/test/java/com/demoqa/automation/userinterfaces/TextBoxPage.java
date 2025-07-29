package com.demoqa.automation.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TextBoxPage extends PageObject {

    public static final Target FULL_NAME = Target.the("Nombre completo").located(By.id("userName"));
    public static final Target EMAIL = Target.the("Email").located(By.id("userEmail"));
    public static final Target CURRENT_ADDRESS = Target.the("Dirección actual").located(By.id("currentAddress"));
    public static final Target PERMANENT_ADDRESS = Target.the("Dirección permanente").located(By.id("permanentAddress"));
    public static final Target SUBMIT = Target.the("Botón Submit").located(By.id("submit"));

    public static final Target OUTPUT_NAME = Target.the("Resultado nombre").located(By.id("name"));
    public static final Target OUTPUT_EMAIL = Target.the("Resultado email").located(By.id("email"));
    public static final Target OUTPUT_CURRENT_ADDRESS = Target.the("Resultado dirección actual").located(By.xpath("//p[@id='currentAddress']"));
    public static final Target OUTPUT_PERMANENT_ADDRESS = Target.the("Resultado dirección permanente").located(By.xpath("//p[@id='permanentAddress']"));
}
