package com.ceuma.neuroapi.domain.models;

import java.beans.Transient;
import java.lang.module.ModuleDescriptor.Builder;
import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.AvaliacaoDtoIn;
import com.ceuma.neuroapi.domain.relations.AvaliacaoOpcao;

import jakarta.persistence.CascadeType;
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
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "fk_hospital")
    private Hospital fk_hospital;

    @OneToMany(mappedBy = "fk_avaliacao", cascade = CascadeType.ALL)
    private List<AvaliacaoOpcao> avaliacoesOpcoes;

    private Avaliacao(AvaliacaoDtoIn av,Hospital hospital){
        this.nome = av.getNome();
        this.status = av.isStatus();
        this.fk_hospital = hospital;
    }
    public Avaliacao(AvaliacaoDtoIn av){
        this.nome = av.getNome();
        this.status = av.isStatus();
    }

}
