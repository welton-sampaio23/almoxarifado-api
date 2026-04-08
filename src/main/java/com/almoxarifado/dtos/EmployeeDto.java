package com.almoxarifado.dtos;

import jakarta.validation.constraints.NotBlank;

public record EmployeeDto(@NotBlank String nameEmployee, @NotBlank String profession) {
}
