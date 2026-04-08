package com.almoxarifado.controllers;

import com.almoxarifado.domain.tools.Tool;
import com.almoxarifado.dtos.LoanToolDto;
import com.almoxarifado.dtos.ToolDto;
import com.almoxarifado.services.ToolService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/tools")
public class ToolController {
    private final ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @PostMapping
    public ResponseEntity<Tool> createTool(@Valid @RequestBody ToolDto dto) {
        Tool newTool = toolService.createTool(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTool);
    }

    @PutMapping("/emprestimos")
    public ResponseEntity<Tool> loanTool(@Valid @RequestBody LoanToolDto dto) {
        Tool loanTool = toolService.loanTool(dto);
        return ResponseEntity.status(HttpStatus.OK).body(loanTool);
    }
}
