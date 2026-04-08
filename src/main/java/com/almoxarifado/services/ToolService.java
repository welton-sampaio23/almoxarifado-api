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

    /*
    Emprestimo de Ferramenta

recebe nomeFerramenta
recebe idFuncionario

se nomeFerramenta for nulo ou vazio ou só espaço ou nomeFuncionario for nulo ou vazio ou só espaço:
	print “Nome da ferramenta ou do funcionário não pode se vazio”
	parar execução
fim se

se nomeFerramenta não existe no banco de dados:
	print “Ferramenta não existe”
	parar execução
fim se

ferramenta = buscar ferramenta no banco

se idFuncionario não existe no banco de dados:
	print “Funcionário não existe”
	parar execução
fim se

funcionario = buscar funcionário no banco

se ferramenta.disponivel é verdadeiro
	ferramenta.responsavel = funcionario
	ferramenta.disponivel = falso
	salvar ferramenta no banco
	print “Ferramenta emprestada com sucesso”
	parar execução
se não:
	print “Ferramenta já está com: “ + ferramenta.responsavel.nome
	parar execução
fim se

     */

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
