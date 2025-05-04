package com.ceuma.neuroapi.domain.relations;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Solucoes {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_avaliacao_opcao")
    private AvaliacaoOpcao fk_avaliacao_opcao;
    @ManyToOne
    @JoinColumn(name = "fk_consulta")
    private Consulta fk_consulta;
}
