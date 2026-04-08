package com.almoxarifado.dtos;

import com.almoxarifado.domain.employee.Employee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record LoanToolDto(@NotNull UUID idEmployee, @NotBlank String nameTool) {
}
