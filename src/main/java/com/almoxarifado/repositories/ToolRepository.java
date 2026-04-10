package com.almoxarifado.repositories;

import com.almoxarifado.domain.employee.Employee;
import com.almoxarifado.domain.tools.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ToolRepository extends JpaRepository<Tool, UUID> {

    // verificar ser ferramenta já existe no banco
    boolean existsByNameTool(String nameTool);

    // Buscar por ferramenta por nome
    Optional<Tool> findByNameTool(String nameTool);

    // Buscar ferramentas disponível
    List<Tool> findByAvailableTrue();

    // Buscar ferramentas emprestadas
    List<Tool> findByAvailableFalse();

    // Buscar por responsável
    List<Tool> findByResponsibleAndAvailableFalse(Employee responsible);

}
