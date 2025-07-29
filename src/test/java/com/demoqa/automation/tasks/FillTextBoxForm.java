package com.demoqa.automation.tasks;

import com.demoqa.automation.userinterfaces.TextBoxPage;

// Screenplay
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillTextBoxForm implements Task {

    // Variables de datos (parametrizadas)
    private final String nombre;
    private final String email;
    private final String direccion1;
    private final String direccion2;

    // Constructor
    public FillTextBoxForm(String nombre, String email, String direccion1, String direccion2) {
        this.nombre = nombre;
        this.email = email;
        this.direccion1 = direccion1;
        this.direccion2 = direccion2;
    }

    // Método estático para instanciar la Task con los datos
    public static FillTextBoxForm with(String nombre, String email, String direccion1, String direccion2) {
        return instrumented(FillTextBoxForm.class, nombre, email, direccion1, direccion2);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Llenamos cada campo, limpiando primero
        actor.attemptsTo(
                Clear.field(TextBoxPage.FULL_NAME),
                Enter.theValue(nombre).into(TextBoxPage.FULL_NAME),

                Clear.field(TextBoxPage.EMAIL),
                Enter.theValue(email).into(TextBoxPage.EMAIL),

                Clear.field(TextBoxPage.CURRENT_ADDRESS),
                Enter.theValue(direccion1).into(TextBoxPage.CURRENT_ADDRESS),

                Clear.field(TextBoxPage.PERMANENT_ADDRESS),
                Enter.theValue(direccion2).into(TextBoxPage.PERMANENT_ADDRESS)
        );
    }
}
