package com.demoqa.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ValidarTituloSteps extends UIInteractionSteps{

    //controlado del navegador que maneja Serenity
    @Managed
    WebDriver navegador;

    String titulo;

    @Given("que el usuario está en la página principal de DemoQA")
    public void abrirPaginaPrincipal(){
        navegador.get("https://demoqa.com/");
    }

    @When("el usuario obtiene el título de la página")
    public void obtenerTitulo(){
        titulo = navegador.getTitle();
    }

    @Then("el título debe ser {string}")
    public void validarTitulo(String tituloEsperado){
        Assert.assertEquals(tituloEsperado,titulo);
    }

}
