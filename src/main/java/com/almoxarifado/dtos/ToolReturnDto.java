package com.almoxarifado.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ToolReturnDto(@NotBlank String nameTool, @NotNull UUID idEmployee) {
}
