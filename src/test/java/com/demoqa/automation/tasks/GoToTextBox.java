package com.demoqa.automation.tasks;

import com.demoqa.automation.userinterfaces.ElementsPage;
import com.demoqa.automation.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToTextBox implements Task {

    public static GoToTextBox section() {
        return instrumented(GoToTextBox.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Click en la tarjeta Elements (correcta)
                Scroll.to(HomePage.ELEMENTS_CARD),
                WaitUntil.the(HomePage.ELEMENTS_CARD, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(HomePage.ELEMENTS_CARD),

                // Click en Text Box del menú lateral
                WaitUntil.the(ElementsPage.TEXT_BOX_OPTION, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(ElementsPage.TEXT_BOX_OPTION),
                Click.on(ElementsPage.TEXT_BOX_OPTION)
        );
    }
}
