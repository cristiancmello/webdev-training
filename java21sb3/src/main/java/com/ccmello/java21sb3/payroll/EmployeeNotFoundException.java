package com.ccmello.java21sb3.payroll;

public class EmployeeNotFoundException extends RuntimeException {
  EmployeeNotFoundException(Long id) {
    super("Could not find employee %s".formatted(id));
  }
}
