package com.ceuma.neuroapi.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceuma.neuroapi.adapters.outbound.dto.hospital.HospitalDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.hospital.HospitalDtoOut;
import com.ceuma.neuroapi.application.repositories.HospitalRepository;
import com.ceuma.neuroapi.domain.models.Hospital;
import com.ceuma.neuroapi.utils.validacoes.ValidarCrendenciaisHospital;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository repository;

    /**
     * A função 'criar nova instituição' vai receber dados de um hospital, vai valida-los.
     * @param hospitalIn
     * @return retorna um objeto do tipo
     */
    public HospitalDtoOut novaInstituicao(HospitalDtoIn hospitalIn){

        // Classe com metodos para validar as credencias de hospitalIn
        ValidarCrendenciaisHospital validacoes = new ValidarCrendenciaisHospital(hospitalIn);
        Hospital hospital = new Hospital(hospitalIn);

        // caso encontre irregularidades no processo irá lançar um erro
        if(validacoes.camposNulos())
            throw new Error("campos nulos");
        if(validacoes.validarPattern())
            throw new Error("pattern errada");

        repository.save(hospital);

        return new HospitalDtoOut(hospital);
    }

    
    public List<HospitalDtoOut> listarTodasInstitutos() {

        // busca trazer a lista da instituicoes no banco
        List<HospitalDtoOut> listOut = repository 
            .findAll()
            .stream()
            .map(HospitalDtoOut::new)
            .toList();

        // caso venha vazia ou nula irá lançar um error
        if(listOut.isEmpty() || listOut == null)
            throw new Error("Sem Instituições");
        return listOut;
    }
    
    public Hospital buscarInstitutoPorId(Long id) {
        return repository.findById(id).orElseThrow();
    }

}
