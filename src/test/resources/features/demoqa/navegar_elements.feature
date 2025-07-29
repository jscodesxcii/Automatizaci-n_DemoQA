Feature: Navegar a Elements

  Scenario: Navegar desde Home a Elements
    Given que el usuario está en la página principal
    When el usuario hace clic en la sección Elements
    Then la URL debe contener "elements"
