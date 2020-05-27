package it.unimi.kata.interfaces;

import java.time.LocalDate;

public interface Employee {

  String getName();

  String getSurname();

  LocalDate getBirthdayDate();

  String getEmail();
}
