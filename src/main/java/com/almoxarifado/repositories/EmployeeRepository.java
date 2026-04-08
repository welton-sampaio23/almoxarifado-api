package com.almoxarifado.repositories;

import com.almoxarifado.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    // Buscar por nome
    Optional<Employee> findByNameEmployee(String nameEmployee);
}
