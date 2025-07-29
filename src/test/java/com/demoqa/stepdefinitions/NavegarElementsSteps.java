package com.demoqa.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.steps.UIInteractionSteps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.JavascriptExecutor;

public class NavegarElementsSteps extends UIInteractionSteps {

    @Managed
    WebDriver navegador;

    // Abrimos la página principal de DemoQA
    @Given("que el usuario está en la página principal")
    public void abrirPaginaPrincipal() {
        navegador.get("https://demoqa.com/");
    }

    // Hacemos clic en la sección Elements
    @When("el usuario hace clic en la sección Elements")
    public void clicEnElements() {
        // Ocultar banner molesto
        ((JavascriptExecutor) navegador).executeScript("document.getElementById('fixedban').style.display='none';");

        WebElement elementsSection = navegador.findElement(By.xpath("//div[@class='card-body']/h5[text()='Elements']"));
        elementsSection.click();
    }

    // Validamos que la URL contiene "elements" para confirmar la navegación
    @Then("la URL debe contener {string}")
    public void validarURL(String textoEsperado) {
        String urlActual = navegador.getCurrentUrl();
        Assert.assertTrue("La URL no contiene: " + textoEsperado, urlActual.contains(textoEsperado));
    }
}
