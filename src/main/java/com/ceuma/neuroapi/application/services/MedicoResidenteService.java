package com.ceuma.neuroapi.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceuma.neuroapi.adapters.outbound.dto.medicoresidente.MedicoResidenteDtoOut;
import com.ceuma.neuroapi.adapters.outbound.dto.medicoresidente.MedicoResidenteIn;
import com.ceuma.neuroapi.application.repositories.HospitalRepository;
import com.ceuma.neuroapi.application.repositories.MedicoResidenteRepository;
import com.ceuma.neuroapi.application.repositories.UsuarioRepository;
import com.ceuma.neuroapi.domain.models.Hospital;
import com.ceuma.neuroapi.domain.models.Usuario;
import com.ceuma.neuroapi.domain.relations.MedicoResidente;

@Service
public class MedicoResidenteService {
    @Autowired
    private MedicoResidenteRepository mrRepository;

    @Autowired
    private HospitalRepository hRepository;


    @Autowired
    private UsuarioRepository uRepository;

    public void registrarUsuariosEmSistemas(MedicoResidenteIn mrIn){
        // busca a entidade de medico na tb Usuario
        MedicoResidente mr = new MedicoResidente(mrIn);
        Usuario medico = uRepository
            .findById(mrIn.getMedico())
            .orElseThrow();

        // busca a entidade de residente na tb Usuario
        Usuario residente = uRepository
            .findById(mrIn.getResidente())
            .orElseThrow();

        // busca a entidade de hospital na tb Hospital
        Hospital hospital = hRepository
            .findById(mrIn.getHospital())
            .orElseThrow();

        mr.setFk_hospital(hospital);
        mr.setFk_medico(medico);
        mr.setFk_residente(residente);
        mr.setStatusResidente(mrIn.getStatus());
            
        // cria um objeto mr na tb de MedicoResidentes

        mrRepository.save(mr);
    }

    public List<MedicoResidenteDtoOut> listarMR(){
        return mrRepository
            .findAll()
            .stream()
            .map(MedicoResidenteDtoOut::new)
            .toList();
    }

    public MedicoResidente findByMedicoResidente(Long id){
        return mrRepository.findById(id).orElseThrow();
    }
}
