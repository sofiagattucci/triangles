Feature: Verifica del tipo di triangolo

  Scenario: Triangolo scaleno
    Given un triangolo con lati 4 3 6
    When chiedo che tipo di triangolo è
    Then ottengo scalene