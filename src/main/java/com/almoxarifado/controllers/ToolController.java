package com.almoxarifado.controllers;

import com.almoxarifado.domain.tools.Tool;
import com.almoxarifado.dtos.EmployeeDto;
import com.almoxarifado.dtos.LoanToolDto;
import com.almoxarifado.dtos.ToolDto;
import com.almoxarifado.dtos.ToolReturnDto;
import com.almoxarifado.services.ToolService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PutMapping("/devolucoes")
    public ResponseEntity<Tool> toolReturn(@Valid @RequestBody ToolReturnDto dto) {
        Tool tool = toolService.toolReturn(dto);
        return ResponseEntity.status(HttpStatus.OK).body(tool);
    }

    @GetMapping("/disponivel")
    public ResponseEntity<List<Tool>> listAvailableTools() {
        List<Tool> listAvailableTools = toolService.listAvailableTools();
        return ResponseEntity.ok(listAvailableTools);
    }

    @GetMapping("/emprestadas")
    public ResponseEntity<List<Tool>> listBorrowedTools() {
        List<Tool> listBorrowed = toolService.listBorrowedTools();
        return ResponseEntity.ok(listBorrowed);
    }

    @GetMapping("/emprestadas/responsavel/{idRes}")
    public ResponseEntity<List<Tool>> listBorrowedResponsible(@PathVariable UUID idRes) {
        List<Tool> listBorrowedResponsible = toolService.listBorrowedResponsible(idRes);

        return ResponseEntity.ok(listBorrowedResponsible);
    }
}
