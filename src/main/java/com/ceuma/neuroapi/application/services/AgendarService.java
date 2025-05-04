package com.ceuma.neuroapi.application.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceuma.neuroapi.adapters.outbound.dto.agendar.AgendarDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.agendar.AgendarDtoOut;
import com.ceuma.neuroapi.application.repositories.ConsultaRepository;
import com.ceuma.neuroapi.domain.relations.Consulta;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class AgendarService {

    @Autowired
    private MedicoResidenteService usuarioService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private ConsultaRepository consultaRepository;

    public void marcar(AgendarDtoIn agendar){
        var paciente = pacienteService.buscarPacientePorId(agendar.getPaciente());
        var residente_medico = usuarioService.findByMedicoResidente(agendar.getResidente());

        Consulta consulta = new Consulta();
        consulta.setDataDaConsulta(LocalDate.now());
        consulta.setFk_Consulta_paciente(paciente);
        consulta.setFk_Consulta_residente_medico(residente_medico);
        
        consultaRepository.save(consulta);
    }

    public List<AgendarDtoOut> buscarConsultas(){
        return consultaRepository
            .findAll()
            .stream()
            .filter(consulta -> consulta != null && consulta.getFk_Consulta_residente_medico() != null)
            .map(AgendarDtoOut::new)
            .toList();
    }
    
}
