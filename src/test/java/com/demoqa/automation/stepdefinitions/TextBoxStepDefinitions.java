package com.demoqa.automation.stepdefinitions;

import com.demoqa.automation.tasks.FillTextBoxForm;
import com.demoqa.automation.tasks.GoToTextBox;
import com.demoqa.automation.tasks.NavigateTo;
import com.demoqa.automation.tasks.SubmitForm;
import com.demoqa.automation.userinterfaces.TextBoxPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.*;
import io.cucumber.datatable.DataTable;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.questions.TextContent.of;
import static org.hamcrest.CoreMatchers.containsString;

public class TextBoxStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver navegador;

    private Actor usuario;

    @Before
    public void setTheStage() {
        usuario = Actor.named("Usuario DemoQA");
        usuario.can(BrowseTheWeb.with(navegador));
    }

    @Given("el usuario está en la página principal")
    public void elUsuarioEstaEnLaPaginaPrincipal() {
        usuario.attemptsTo(NavigateTo.home());
    }

    @When("el usuario navega y completa el formulario con los datos:")
    public void elUsuarioNavegaYCompletaElFormularioConLosDatos(DataTable dataTable) {
        Map<String, String> datos = dataTable.asMap(String.class, String.class);

        usuario.attemptsTo(
                GoToTextBox.section(),
                FillTextBoxForm.with(
                        datos.get("nombre"),
                        datos.get("email"),
                        datos.get("direccion1"),
                        datos.get("direccion2")
                ),
                SubmitForm.now()
        );
    }

    @Then("el formulario debe mostrar los datos ingresados correctamente")
    public void elFormularioDebeMostrarLosDatosIngresadosCorrectamente() {
        usuario.should(
                seeThat("El nombre es correcto", of(TextBoxPage.OUTPUT_NAME), containsString("Juan Pérez")),
                seeThat("El email es correcto", of(TextBoxPage.OUTPUT_EMAIL), containsString("juan@test.com")),
                seeThat("La dirección actual es correcta", of(TextBoxPage.OUTPUT_CURRENT_ADDRESS), containsString("Calle Falsa 123")),
                seeThat("La dirección permanente es correcta", of(TextBoxPage.OUTPUT_PERMANENT_ADDRESS), containsString("Avenida Siempre Viva"))
        );
    }
}
