package com.almoxarifado.repositories;

import com.almoxarifado.domain.Ferramenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FerramentaRepository extends JpaRepository<Ferramenta, UUID> {

    Optional<Ferramenta> findByNomeFerramenta(String nome);
    List<Ferramenta> findByResponsavel(String responsavel);

    boolean existsByNomeFerramenta(String nome);
}
