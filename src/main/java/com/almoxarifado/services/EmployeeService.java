package com.almoxarifado.services;

import com.almoxarifado.domain.employee.Employee;
import com.almoxarifado.dtos.EmployeeDto;
import com.almoxarifado.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(EmployeeDto dto) {
        String name = dto.nameEmployee();
        String profession = dto.profession();

        if (name == null || name.trim().isEmpty() || profession == null || profession.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do funcionário ou cargo não pode ser vazio");
        }

        name = name.trim().toLowerCase();
        profession = profession.trim().toLowerCase();

        Employee newEmployee = new Employee(name, profession);
        return employeeRepository.save(newEmployee);
    }

    public List<Employee> listEmployees() {
        return employeeRepository.findAll();
    }

}
