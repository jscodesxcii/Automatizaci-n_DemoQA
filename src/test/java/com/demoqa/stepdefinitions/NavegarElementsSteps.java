package com.demoqa.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import io.cucumber.datatable.DataTable;
import java.util.Map;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.UIInteractionSteps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.JavascriptExecutor;

import com.demoqa.stepdefinitions.ScrollSteps;

public class NavegarElementsSteps extends UIInteractionSteps {

    @Managed
    WebDriver navegador;

    // Inyectamos el ScrollSteps de Serenity
    @Steps
    ScrollSteps scroll;

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

    @And("el usuario hace clic en la opción Text Box")
    public void clicEnTextBox(){
        //Buscamos la opción Text Box en el menú lateral
        WebElement textBoxOption = navegador.findElement(By.xpath("//span[text()='Text Box']"));
        textBoxOption.click();
    }

    @And("el usuario llena el formulario con los datos:")
    public void llenarFormulario(DataTable dataTable){

        //Convertimos la tabla en un mapa
        Map<String, String> datos = dataTable.asMap(String.class, String.class);

        //Llenamos los campos
        navegador.findElement(By.id("userName")).sendKeys(datos.get("nombre"));
        navegador.findElement(By.id("userEmail")).sendKeys(datos.get("email"));
        navegador.findElement(By.id("currentAddress")).sendKeys(datos.get("direccion1"));
        navegador.findElement(By.id("permanentAddress")).sendKeys(datos.get("direccion2"));

        //Desplazamos la pantalla para mostrar el botón Submit y el bloque de salida
        scroll.scrollDown();
    }

    @And("el usuario hace clic en el botón Submit")
    public void clicEnSubmit(){
        navegador.findElement(By.id("submit")).click();
    }

    @Then("el formulario debe mostrar los datos ingresados correctamente")
    public void validarDatosMostrados() {
        String resultado = navegador.findElement(By.id("output")).getText();

        System.out.println("Resultado mostrado:\n" + resultado);

        Assert.assertTrue(resultado.contains("Juan Pérez"));
        Assert.assertTrue(resultado.contains("juan@test.com"));
        Assert.assertTrue(resultado.contains("Calle Falsa 123"));
        Assert.assertTrue(resultado.contains("Avenida Siempre Viva"));
    }

    // Validamos que la URL contiene "elements" para confirmar la navegación
    @Then("la URL debe contener {string}")
    public void validarURL(String textoEsperado) {
        String urlActual = navegador.getCurrentUrl();
        Assert.assertTrue("La URL no contiene: " + textoEsperado, urlActual.contains(textoEsperado));
    }

}
