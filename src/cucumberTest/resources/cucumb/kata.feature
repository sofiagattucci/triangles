Feature: invio mail di compleanno

  Scenario: selezione degli utenti che compiono gli anni oggi
    Given i seguenti impiegati
    """
    Mario, Bros, 1996/12/29, mario.bros@mail.it
    Luigi, Bros, 1996/12/29, luigi.bros@mail.it
    Donkey, Kong, 1996/05/04, donkey.kong@mail.it
    Bowser, Koopa, 1994/02/28, bowser.koopa@mail.it
    Peach, ToadStool, 1994/12/03, peach.toadstool@mail.it
    Daisy, ToadStool, 1994/12/03, daisy.toadstool@mail.it
    """
    And oggi è il giorno 2020-12-03
    When chiedo a chi devo mandare la mail
    Then ottengo la seguente lista:
    | Peach | ToadStool | 1994/12/03 | peach.toadstool@mail.it |
    | Daisy | ToadStool | 1994/12/03 | daisy.toadstool@mail.it |

