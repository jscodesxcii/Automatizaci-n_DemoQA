package com.demoqa.automation.tasks;

import com.demoqa.automation.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateTo implements Task {
    private final HomePage homePage = new HomePage();

    public static NavigateTo home() {
        return instrumented(NavigateTo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(homePage));
    }
}
