package com.almoxarifado.controllers;

import com.almoxarifado.domain.employee.Employee;
import com.almoxarifado.dtos.EmployeeDto;
import com.almoxarifado.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDto dto) {
        Employee newEmployee = employeeService.createEmployee(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Employee>> listEmployees() {
        List<Employee> list = employeeService.listEmployees();
        return ResponseEntity.ok(list);
    }
}
