package com.ceuma.neuroapi.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceuma.neuroapi.domain.relations.MedicoResidente;

@Repository
public interface MedicoResidenteRepository extends JpaRepository<MedicoResidente,Long> {}
