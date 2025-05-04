package com.ceuma.neuroapi.application.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.pergunta.PerguntaDtoIn;
import com.ceuma.neuroapi.application.repositories.PerguntaRepository;
import com.ceuma.neuroapi.domain.models.Avaliacao;
import com.ceuma.neuroapi.domain.models.Opcao;
import com.ceuma.neuroapi.domain.models.Pergunta;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class PerguntaService {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private OpcaoService opcaoService;

    public void salvarPergunta(Pergunta perguntaIn, Avaliacao av) {
        if (perguntaIn == null)
            throw new Error("Pergunta não existe");

        perguntaRepository.save(perguntaIn);
    }

    public void criarPerguntasNaoAncoradas(List<PerguntaDtoIn> perguntaIn,Long id) {
        List<Pergunta> perguntas = perguntaIn.stream().map(Pergunta::new).toList();
        perguntaRepository.saveAll(perguntas);
        for (var pergunta : perguntas) {
            Function<Opcao, Opcao> setPerguntaEmOpcao = (opcaoLambda) -> {
                opcaoLambda.setFk_pergunta(pergunta);
                return opcaoLambda;
            };
            List<Opcao> opcoes = pergunta
                    .getOpcoes()
                    .stream()
                    .map(setPerguntaEmOpcao)
                    .toList();
            opcaoService.criarOpcao(opcoes,id);
            

        }
    }

    public List<Pergunta> criarPerguntasAncoradas(List<Pergunta> perguntas, Long id) {
        List<Pergunta> perguntasOut = perguntaRepository.saveAll(perguntas);

        for (var pergunta : perguntasOut) {
            Function<Opcao, Opcao> setPerguntaEmOpcao = (opcaoLambda) -> {
                opcaoLambda.setFk_pergunta(pergunta);
                return opcaoLambda;
            };
            List<Opcao> opcoes = pergunta
                    .getOpcoes()
                    .stream()
                    .map(setPerguntaEmOpcao)
                    .toList();
            opcaoService.criarOpcao(opcoes, id);
        }
        return perguntasOut;
    }

}
