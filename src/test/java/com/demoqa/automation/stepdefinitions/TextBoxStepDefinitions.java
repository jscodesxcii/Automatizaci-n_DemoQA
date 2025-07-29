package com.demoqa.automation.stepdefinitions;

// Importamos las Tasks y PageObjects que usaremos
import com.demoqa.automation.tasks.FillTextBoxForm;
import com.demoqa.automation.tasks.GoToTextBox;
import com.demoqa.automation.tasks.NavigateTo;
import com.demoqa.automation.tasks.SubmitForm;
import com.demoqa.automation.userinterfaces.TextBoxPage;

// Importamos anotaciones de Cucumber
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

// Serenity Screenplay
import net.serenitybdd.annotations.Managed; // Para manejar el navegador
import net.serenitybdd.screenplay.Actor; // Representa al "usuario" que ejecuta las acciones
import net.serenitybdd.screenplay.abilities.BrowseTheWeb; // Habilidad para navegar con WebDriver
import org.openqa.selenium.WebDriver; // Selenium WebDriver

// Java util para el DataTable
import java.util.Map;

// Asserts con Screenplay
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.questions.TextContent.of;
import static org.hamcrest.CoreMatchers.containsString;

public class TextBoxStepDefinitions {

    @Managed(driver = "chrome") // Serenity crea y gestiona el WebDriver de Chrome
    WebDriver navegador;

    private Actor usuario; // Actor de Screenplay, el "usuario" que hace los pasos

    @Before // Se ejecuta antes de cada escenario de Cucumber
    public void setTheStage() {
        usuario = Actor.named("Usuario DemoQA"); // Creamos el actor
        usuario.can(BrowseTheWeb.with(navegador)); // Le damos la habilidad de usar el navegador
    }

    @Given("el usuario está en la página principal")
    public void elUsuarioEstaEnLaPaginaPrincipal() {
        // Llamamos la Task NavigateTo, que abre https://demoqa.com/
        usuario.attemptsTo(NavigateTo.home());
    }

    @When("el usuario navega y completa el formulario con los datos:")
    public void elUsuarioNavegaYCompletaElFormularioConLosDatos(DataTable dataTable) {
        // Convertimos la DataTable (tabla de Gherkin) a un Map clave/valor
        Map<String, String> datos = dataTable.asMap(String.class, String.class);
        // Ejecutamos varias Tasks en orden:
        usuario.attemptsTo(
                GoToTextBox.section(), // Navega a Elements -> Text Box
                FillTextBoxForm.with(
                        datos.get("nombre"),
                        datos.get("email"),
                        datos.get("direccion1"),
                        datos.get("direccion2")
                ),
                SubmitForm.now() // Hace scroll, clic en Submit y scroll a los resultados
        );
    }

    @Then("el formulario debe mostrar los datos ingresados correctamente")
    public void elFormularioDebeMostrarLosDatosIngresadosCorrectamente() {
        // Validamos que los datos mostrados en pantalla contengan los valores esperados
        usuario.should(
                seeThat("El nombre es correcto", of(TextBoxPage.OUTPUT_NAME), containsString("Juan Pérez")),
                seeThat("El email es correcto", of(TextBoxPage.OUTPUT_EMAIL), containsString("juan@test.com")),
                seeThat("La dirección actual es correcta", of(TextBoxPage.OUTPUT_CURRENT_ADDRESS), containsString("Calle Falsa 123")),
                seeThat("La dirección permanente es correcta", of(TextBoxPage.OUTPUT_PERMANENT_ADDRESS), containsString("Avenida Siempre Viva"))
        );
    }
}
