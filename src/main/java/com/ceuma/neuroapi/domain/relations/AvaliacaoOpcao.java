package com.ceuma.neuroapi.domain.relations;


import java.util.List;

import com.ceuma.neuroapi.domain.models.Avaliacao;
import com.ceuma.neuroapi.domain.models.Opcao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoOpcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvOp;

    @ManyToOne
    @JoinColumn(name = "fk_avaliacao")
    private Avaliacao fk_avaliacao;

    @ManyToOne
    @JoinColumn(name = "fk_opcao")
    private Opcao fk_opcao;

    @ManyToOne
    @JoinColumn(name = "fk_consulta")
    private Consulta fk_consulta;

    @OneToMany(mappedBy = "fk_avaliacao_opcao")
    private List<Solucoes> solucoes;



    public AvaliacaoOpcao(Avaliacao av,Opcao op){
        this.fk_avaliacao = av;
        this.fk_opcao = op;
    }
}
