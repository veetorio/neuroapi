package com.ceuma.neuroapi.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceuma.neuroapi.domain.models.Hospital;


@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> {
    
}
