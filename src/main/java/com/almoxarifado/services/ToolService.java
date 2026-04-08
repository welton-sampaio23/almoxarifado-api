package com.almoxarifado.services;

import com.almoxarifado.domain.employee.Employee;
import com.almoxarifado.domain.tools.Tool;
import com.almoxarifado.dtos.LoanToolDto;
import com.almoxarifado.dtos.ToolDto;
import com.almoxarifado.repositories.EmployeeRepository;
import com.almoxarifado.repositories.ToolRepository;
import org.springframework.stereotype.Service;

@Service
public class ToolService {
    private final ToolRepository toolRepository;
    private final EmployeeRepository employeeRepository;

    public ToolService(ToolRepository toolRepository, EmployeeRepository employeeRepository) {
        this.toolRepository = toolRepository;
        this.employeeRepository = employeeRepository;
    }

    public Tool createTool(ToolDto dto) {
        String name = dto.nameTool();
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da ferramenta não pode ser vazio");
        }

        name = name.trim().toLowerCase();
        if (toolRepository.existsByNameTool(name)) {
            throw new IllegalArgumentException("Ferramenta já cadastrada");
        }

        Tool tool = new Tool(name);
        return toolRepository.save(tool);
    }

    public Tool loanTool(LoanToolDto dto) {
        String nameTool = dto.nameTool();
        if (nameTool == null || nameTool.trim().isEmpty() || dto.idEmployee() == null) {
            throw new IllegalArgumentException("Nome da ferramenta ou id do funcionário não pode se vazio");
        }

        nameTool = nameTool.trim().toLowerCase();
        Tool tool = toolRepository.findByNameTool(nameTool).orElseThrow(() -> new IllegalArgumentException("Ferramenta não existe"));
        Employee employee = employeeRepository.findById(dto.idEmployee()).orElseThrow(() -> new IllegalArgumentException("Funcionário não existe"));

        if (tool.isAvailable()) {
            tool.setResponsible(employee);
            tool.setAvailable(false);
        } else {
            throw new IllegalArgumentException("Ferramenta já está com: " + tool.getResponsible().getNameEmployee());
        }
        return toolRepository.save(tool);
    }
}
