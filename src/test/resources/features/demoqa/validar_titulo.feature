Feature: Validar título de la página DemoQA

  Scenario: Validar que el título de la página principal es correcto
    Given que el usuario está en la página principal de DemoQA
    When el usuario obtiene el título de la página
    Then el título debe ser "DEMOQA"
