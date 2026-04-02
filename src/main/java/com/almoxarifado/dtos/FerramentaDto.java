package com.almoxarifado.dtos;

import jakarta.validation.constraints.NotBlank;

public record FerramentaDto(@NotBlank String nomeFerramenta) {
}
