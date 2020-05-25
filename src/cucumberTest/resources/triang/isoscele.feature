Feature: Verifica del tipo di triangolo

  Scenario: Triangolo isoscele
    Given un triangolo con lati 4 4 7
    When chiedo che tipo di triangolo è
    Then ottengo isosceles