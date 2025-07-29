package com.demoqa.automation.tasks;

import com.demoqa.automation.userinterfaces.ElementsPage;// Target de Text Box
import com.demoqa.automation.userinterfaces.HomePage;// Target de tarjeta Elements

// Screenplay imports
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToTextBox implements Task {

    // Método estático para crear la Task
    public static GoToTextBox section() {
        return instrumented(GoToTextBox.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Primero nos aseguramos de ver la tarjeta Elements en la Home
                Scroll.to(HomePage.ELEMENTS_CARD),
                WaitUntil.the(HomePage.ELEMENTS_CARD, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.ELEMENTS_CARD), // Hacemos clic

                // Luego esperamos a que aparezca el menú lateral con Text Box
                WaitUntil.the(ElementsPage.TEXT_BOX_OPTION, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(ElementsPage.TEXT_BOX_OPTION),
                Click.on(ElementsPage.TEXT_BOX_OPTION) // Clic en Text Box
        );
    }
}
