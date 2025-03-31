package com.ceuma.neuroapi.domain.models;

import java.time.LocalDate;

import com.ceuma.neuroapi.adapters.outbound.dto.paciente.PacienteDtoIn;
import com.ceuma.neuroapi.utils.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    @Column(length = 20, nullable = true)
    private String leito;

    @Column(length = 60, nullable = true)
    private String nome;

    @Column(nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataDeNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_hospital")
    private Hospital fk_hospital;

    public Paciente(PacienteDtoIn pacienteDtoIn) {
        this.nome = pacienteDtoIn.getNome();
        this.sexo = pacienteDtoIn.getSexo();
        this.leito = pacienteDtoIn.getLeito();
        this.dataDeNascimento = pacienteDtoIn.getNascimento();
    }

}