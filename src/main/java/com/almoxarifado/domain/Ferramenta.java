package com.almoxarifado.domain;

import com.almoxarifado.dtos.FerramentaDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tbl_ferramentas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "idFerramenta")

public class Ferramenta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idFerramenta;
    private String nomeFerramenta;
    private String responsavel;
    private Boolean disponivel;

    public Ferramenta(FerramentaDto dto) {
        this.nomeFerramenta = dto.nomeFerramenta();
        this.responsavel = null;
        this.disponivel = true;
    }
}
