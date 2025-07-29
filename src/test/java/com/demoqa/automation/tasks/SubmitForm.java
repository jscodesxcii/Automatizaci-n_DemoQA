package com.demoqa.automation.tasks;

import com.demoqa.automation.userinterfaces.TextBoxPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SubmitForm implements Task {

    public static SubmitForm now() {
        return instrumented(SubmitForm.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(TextBoxPage.SUBMIT),
                WaitUntil.the(TextBoxPage.SUBMIT, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(TextBoxPage.SUBMIT),
                Scroll.to(TextBoxPage.OUTPUT_NAME)
        );
    }
}
