Feature: Navegar a Text Box y llenar formulario

  Scenario: Llenar formulario y hacer clic para enviar
    Given el usuario está en la página principal
    When el usuario navega y completa el formulario con los datos:
      | nombre     | Juan Pérez           |
      | email      | juan@test.com        |
      | direccion1 | Calle Falsa 123      |
      | direccion2 | Avenida Siempre Viva |
    Then el formulario debe mostrar los datos ingresados correctamente
