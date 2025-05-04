package com.ceuma.neuroapi.domain.models;

import java.util.ArrayList;
import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.pergunta.PerguntaDtoIn;

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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPergunta;
     
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fk_grupo")
    private Grupo fk_grupo;

    @OneToMany(mappedBy = "fk_pergunta")
    private List<Opcao> opcoes;

    public Pergunta(PerguntaDtoIn perguntaDtoIn){
        this.descricao = perguntaDtoIn.getEnunciado();
        this.opcoes = perguntaDtoIn.getOpcoes() != null ? perguntaDtoIn.getOpcoes().stream().map(Opcao::new).toList() : new ArrayList<>();
    }
}
