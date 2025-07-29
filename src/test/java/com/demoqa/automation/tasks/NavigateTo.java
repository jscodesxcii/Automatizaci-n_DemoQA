package com.demoqa.automation.tasks;

import com.demoqa.automation.userinterfaces.HomePage; // PageObject de la Home

// Screenplay imports
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateTo implements Task {
    // Instancia de HomePage, que tiene la URL base
    private final HomePage homePage = new HomePage();

    // Método estático para crear la Task
    public static NavigateTo home() {
        return instrumented(NavigateTo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Abre el navegador en la URL de HomePage (usa @DefaultUrl)
        actor.attemptsTo(Open.browserOn().the(homePage));
    }
}
