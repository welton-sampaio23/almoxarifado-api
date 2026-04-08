package com.almoxarifado.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record LoanToolDto(@NotNull UUID idEmployee, @NotBlank String nameTool) {
}
