package com.ccmello.java21sb3.payroll;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class EmployeeRestController {
  private final EmployeeRepository repository;

  EmployeeRestController(EmployeeRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/rest-employees")
  CollectionModel<EntityModel<Employee>> all() {
    var employees = repository.findAll()
      .stream()
      .map(employee -> EntityModel.of(employee,
        linkTo(methodOn(EmployeeRestController.class).one(employee.getId())).withSelfRel(),
        linkTo(methodOn(EmployeeRestController.class).all()).withRel("rest-employees")
      )).collect(Collectors.toList());

    return CollectionModel.of(employees, linkTo(methodOn(EmployeeRestController.class).all()).withSelfRel());
  }

  @GetMapping("/rest-employees/{id}")
  EntityModel<Employee> one(@PathVariable Long id) {
    var employee = repository.findById(id)
      .orElseThrow(() -> new EmployeeNotFoundException(id));

    return EntityModel.of(
      employee,
      linkTo(methodOn(EmployeeRestController.class).one(id)).withSelfRel(),
      linkTo(methodOn(EmployeeRestController.class).all()).withRel("rest-employees")
    );
  }
}
