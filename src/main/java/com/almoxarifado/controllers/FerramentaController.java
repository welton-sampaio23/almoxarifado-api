package com.almoxarifado.controllers;

import com.almoxarifado.domain.Ferramenta;
import com.almoxarifado.dtos.EmprestaFerramentaDto;
import com.almoxarifado.dtos.FerramentaDto;
import com.almoxarifado.services.FerramentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ferramentas")
public class FerramentaController {
    private final FerramentaService service;

    public FerramentaController(FerramentaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Ferramenta> cadastroFerramenta(@Valid @RequestBody FerramentaDto dto) throws Exception {
        Ferramenta ferramenta = service.cadastroFerramenta(dto);
        return new ResponseEntity<>(ferramenta, HttpStatus.CREATED);
    }

    @PutMapping("/emprestar")
    public ResponseEntity<Ferramenta> emprestarFerramenta(@Valid @RequestBody EmprestaFerramentaDto dto) {
        Ferramenta updateFerramenta = service.emprestaFerramenta(dto);
        return new ResponseEntity<>(updateFerramenta, HttpStatus.OK);
    }

    @PutMapping("/devolucao")
    public ResponseEntity<Ferramenta> devolucaoFerramenta(@Valid @RequestBody FerramentaDto dto) {
        Ferramenta devolucaoFerramenta = service.devolucaoFerramenta(dto);
        return new ResponseEntity<>(devolucaoFerramenta, HttpStatus.OK);
    }

    @GetMapping("/responsavel/{responsavel}")
    public ResponseEntity<List<Ferramenta>> listarFerramentasEmprestadaResponsavel(@PathVariable String responsavel) {
        List<Ferramenta> lista = service.listFerramentasEmprestadaResponsavel(responsavel);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

}
