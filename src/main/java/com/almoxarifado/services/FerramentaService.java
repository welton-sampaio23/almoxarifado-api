package com.almoxarifado.services;

import com.almoxarifado.domain.Ferramenta;
import com.almoxarifado.dtos.EmprestaFerramentaDto;
import com.almoxarifado.dtos.FerramentaDto;
import com.almoxarifado.repositories.FerramentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FerramentaService {
    private final FerramentaRepository repository;

    public FerramentaService(FerramentaRepository repository) {
        this.repository = repository;
    }

    public Ferramenta cadastroFerramenta(FerramentaDto dto) {
        if (repository.existsByNomeFerramenta(dto.nomeFerramenta())) {
            throw new RuntimeException("Ferramenta já cadastrada");
        }
        Ferramenta newFerramenta = new Ferramenta(dto);
        return repository.save(newFerramenta);
    }

    public Ferramenta emprestaFerramenta(EmprestaFerramentaDto dto) {
        Ferramenta ferramentaExiste = repository.findByNomeFerramenta(dto.nomeFerramenta()).orElseThrow(() -> new RuntimeException("Ferramenta não encontrada"));

        if (ferramentaExiste.getDisponivel()) {
            ferramentaExiste.setResponsavel(dto.responsavel());
            ferramentaExiste.setDisponivel(false);
        } else {
            throw new RuntimeException("Ferramenta já está emprestada");
        }

        return repository.save(ferramentaExiste);
    }

    public Ferramenta devolucaoFerramenta(FerramentaDto dto) {
        Ferramenta devolucaoFerramenta = repository.findByNomeFerramenta(dto.nomeFerramenta()).orElseThrow(() -> new  RuntimeException("Ferramenta não encontrada"));
        if (devolucaoFerramenta.getDisponivel()) {
            throw new RuntimeException("Ferramenta já devolvida");
        } else {
            devolucaoFerramenta.setResponsavel(null);
            devolucaoFerramenta.setDisponivel(true);
        }
        return repository.save(devolucaoFerramenta);
    }

    public List<Ferramenta> listFerramentasEmprestadaResponsavel(String responsavel) {
        return repository.findByResponsavel(responsavel);
    }
}
