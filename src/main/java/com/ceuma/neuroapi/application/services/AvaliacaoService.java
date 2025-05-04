package com.ceuma.neuroapi.application.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceuma.neuroapi.adapters.outbound.dto.agendar.AgendarDtoOut;
import com.ceuma.neuroapi.adapters.outbound.dto.exams.AvaliacaoDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.exams.AvaliacaoDtoOut;
import com.ceuma.neuroapi.adapters.outbound.dto.exams.opcoes.GrupoDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.exams.pergunta.PerguntaDtoIn;
import com.ceuma.neuroapi.application.repositories.AvaliacaoRepository;
import com.ceuma.neuroapi.domain.models.Avaliacao;
import com.ceuma.neuroapi.domain.models.Hospital;
import com.ceuma.neuroapi.domain.models.Usuario;
import com.ceuma.neuroapi.domain.relations.MedicoResidente;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Transactional
@Service
public class AvaliacaoService {

    
    @Autowired
    private HospitalService hospitalService;
    
    @Autowired
    private PerguntaService perguntaService;
    
    @Autowired
    private GrupoService grupoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    

    public List<AvaliacaoDtoOut> findAllAvaliacao(){
        return avaliacaoRepository.findAll().stream().map(AvaliacaoDtoOut::new).toList();
    }


    public String salvarAvaliacao(AvaliacaoDtoIn avaliacaoIn){

        var avaliacao = avaliacaoRepository.save(new Avaliacao(avaliacaoIn));

        var hospital = hospitalService.buscarInstitutoPorId(avaliacaoIn.getFkHospital());

        avaliacao.setFk_hospital(hospital);
        
        avaliacaoRepository.save(avaliacao);
        
        // perguntas ancoradas em grupos
        List<GrupoDtoIn> grupos = avaliacaoIn
            .getGrupos()
            .stream()
            .toList();

        // perguntas não ancoradas
        List<PerguntaDtoIn> perguntas = avaliacaoIn
            .getPerguntas()
            .stream()
            .toList();
        

        grupoService.salvarCadeiaGrupo(grupos,avaliacao.getId());

        perguntaService.criarPerguntasNaoAncoradas(perguntas,avaliacao.getId());

        return "Salbo";
    }


    public Avaliacao findAvaliacaoById(Long id){
        return avaliacaoRepository.findById(id).orElseThrow();
    }

    public List<AgendarDtoOut> findAllAvaliacaoPerIdUser(Long id) {
        Usuario user =  usuarioService.searchUsuarioById(id);

        if (user.getResidentes() == null || user.getResidentes().isEmpty()) {
            return List.of();
        }
    
        return user
            .getResidentes()
            .stream()
            .map(MedicoResidente::getConsultas)
            .flatMap(List::stream)
            .filter(Objects::nonNull)
            .distinct()
            .map(AgendarDtoOut::new)
            .toList();
            
    }
    
    
}
