package com.ceuma.neuroapi.domain.relations;

import java.time.LocalDate;
import java.util.List;

import com.ceuma.neuroapi.domain.models.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDate dataDaConsulta;

    @ManyToOne
    @JoinColumn(name = "fk_Consulta_residente")
    private MedicoResidente fk_Consulta_residente_medico;

    @ManyToOne
    @JoinColumn(name = "fk_Consulta_paciente")
    private Paciente fk_Consulta_paciente;

    @OneToMany(mappedBy = "fk_consulta")
    private List<Solucoes> solucoes;


}
