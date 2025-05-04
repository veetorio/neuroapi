package com.ceuma.neuroapi.application.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceuma.neuroapi.adapters.outbound.dto.exams.opcoes.GrupoDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.exams.opcoes.GrupoDtoOut;
import com.ceuma.neuroapi.application.repositories.GrupoRepository;
import com.ceuma.neuroapi.domain.models.Grupo;
import com.ceuma.neuroapi.domain.models.Pergunta;

import jakarta.transaction.Transactional;
@Transactional
@Service
public class GrupoService {
    @Autowired
    private GrupoRepository gRepository;

    @Autowired
    private PerguntaService perguntaService;

    public List<GrupoDtoOut> listarGrupos(){
        return gRepository.findAll().stream().map(GrupoDtoOut::new).toList();
    }

    public void salvarGrupo(GrupoDtoIn grupoDtoIn,Long id){

        Grupo grupo = gRepository.save(new Grupo(grupoDtoIn));

        Function<Pergunta,Pergunta> setGrupo = (pergunta) ->{ 
            pergunta.setFk_grupo(grupo);
            return pergunta;
        };

        List<Pergunta> perguntasAncoradas = perguntaService.criarPerguntasAncoradas(
            grupoDtoIn
            .getPerguntas()
            .stream()
            .map(Pergunta::new)
            .map(setGrupo)
            .toList()
            ,id);

        grupo.setPerguntas(perguntasAncoradas);

        gRepository.save(grupo);
    }
    public void salvarCadeiaGrupo(List<GrupoDtoIn> gruposDtoIn,Long id){
        for(var grupoIn : gruposDtoIn){

            Grupo grupo = gRepository.save(new Grupo(grupoIn));

            Function<Pergunta,Pergunta> setGrupo = (pergunta) ->{ 
                pergunta.setFk_grupo(grupo);
                return pergunta;
            };    

            List<Pergunta> perguntasAncoradas = perguntaService.criarPerguntasAncoradas(
                grupoIn
                .getPerguntas()
                .stream()
                .map(Pergunta::new)
                .map(setGrupo)
                .toList()
                ,id);

            grupo.setPerguntas(perguntasAncoradas);

            gRepository.save(grupo);
        }
    }

    public List<Grupo> buscarPorGrupo(Long id){
        return gRepository.findByListIdGrupo(id);
    }
}
