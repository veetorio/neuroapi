package com.ceuma.neuroapi.domain.models;

import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.opcoes.OpcaoDtoIn;
import com.ceuma.neuroapi.domain.relations.AvaliacaoOpcao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Opcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOpcao;

    private String descricao;

    private Long valor = 0L;

    @OneToMany(mappedBy = "fk_opcao")
    private List<AvaliacaoOpcao> avaliacoes;


    @ManyToOne
    private Pergunta fk_pergunta;

    public Opcao(OpcaoDtoIn dtoIn){
        this.descricao = dtoIn.getDescricao();
        this.valor = dtoIn.getValor();
    }
}
