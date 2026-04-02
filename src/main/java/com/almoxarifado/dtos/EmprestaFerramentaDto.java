package com.almoxarifado.dtos;

import jakarta.validation.constraints.NotBlank;

public record EmprestaFerramentaDto(@NotBlank String nomeFerramenta, @NotBlank String responsavel) {
}
