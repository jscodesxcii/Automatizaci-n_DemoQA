Feature: Navegar a Text Box y llenar formulario

  Scenario: Llenar el formulario de Text Box
    Given que el usuario está en la página principal
    When el usuario hace clic en la sección Elements
    And el usuario hace clic en la opción Text Box
    And el usuario llena el formulario con los datos:
      | nombre        | Juan Pérez        |
      | email         | juan@test.com     |
      | direccion1    | Calle Falsa 123   |
      | direccion2    | Avenida Siempre Viva |
    And el usuario hace clic en el botón Submit
    Then el formulario debe mostrar los datos ingresados correctamente