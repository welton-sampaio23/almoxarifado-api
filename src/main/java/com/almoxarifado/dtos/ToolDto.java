package com.almoxarifado.dtos;

import jakarta.validation.constraints.NotBlank;

public record ToolDto(@NotBlank String nameTool) {
}
