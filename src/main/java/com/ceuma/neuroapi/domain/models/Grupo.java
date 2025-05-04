package com.ceuma.neuroapi.domain.models;

import java.util.ArrayList;
import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.opcoes.GrupoDtoIn;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Grupo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrupo;

    private String nameGrupo;

    @OneToMany(mappedBy = "fk_grupo")
    private List<Pergunta> perguntas;

    public Grupo(GrupoDtoIn inGrupo){
        this.nameGrupo = inGrupo.getNome();
        this.perguntas = new ArrayList<>();
        
    }
}
