package com.ceuma.neuroapi.domain.models;

import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.hospital.HospitalDtoIn;
import com.ceuma.neuroapi.domain.relations.MedicoResidente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHospital;
    
    @Column(length = 60,nullable = true)
    private String nome;

    @OneToMany(mappedBy = "fk_hospital")
    private List<MedicoResidente> medicoResidente;

    @OneToMany(mappedBy = "fk_hospital")
    private List<Paciente> pacientes;

    @OneToMany(mappedBy = "fk_hospital")
    private List<Avaliacao> avaliacoes;


    public Hospital(HospitalDtoIn hospitalDtoIn) {
        this.nome = hospitalDtoIn.getNome();
        this.pacientes = hospitalDtoIn.getPacientesIn().stream().map(Paciente::new).toList();
    }
    
}