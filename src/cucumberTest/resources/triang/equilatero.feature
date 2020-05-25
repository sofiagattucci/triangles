Feature: Verifica del tipo di triangolo

  Scenario: Triangolo equilatero
    Given un triangolo con lati 4 4 4
    When chiedo che tipo di triangolo è
    Then ottengo equilateral