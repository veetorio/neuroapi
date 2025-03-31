package com.ceuma.neuroapi.domain.relations;

import com.ceuma.neuroapi.domain.models.Hospital;
import com.ceuma.neuroapi.domain.models.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MedicoResidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean statusResidente;

    @ManyToOne
    @JoinColumn(name = "fk_hospital")
    private Hospital fk_hospital;

    @ManyToOne
    @JoinColumn(name = "fk_medico")
    private Usuario fk_medico;

    @ManyToOne
    @JoinColumn(name = "fk_residente")
    private Usuario fk_residente;

    
}
