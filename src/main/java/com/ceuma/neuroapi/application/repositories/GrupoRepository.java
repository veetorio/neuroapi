package com.ceuma.neuroapi.application.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ceuma.neuroapi.domain.models.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
    @Query("SELECT g FROM Grupo g WHERE g.idGrupo = :idGrupo") // Assumindo que 'idGrupo' é o nome correto do campo
    List<Grupo> findByListIdGrupo(@Param("idGrupo") Long idGrupo);
}
