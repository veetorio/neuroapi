package com.ceuma.neuroapi.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ceuma.neuroapi.adapters.outbound.dto.hospital.HospitalDtoIn;
import com.ceuma.neuroapi.adapters.outbound.dto.hospital.HospitalDtoOut;
import com.ceuma.neuroapi.application.services.HospitalService;
import com.ceuma.neuroapi.domain.models.Hospital;

@SpringBootTest
public class CaseTestServiceHospitais {
    

    @Mock
    HospitalService service;

    @InjectMocks
    HospitalService service2;

    @Test
    void CaseTestCreateWithAHospital(){
        
        // testar se usuarios
        HospitalDtoIn in = new HospitalDtoIn("generic hospital", new ArrayList<>());
        Hospital hospital = new Hospital(in);
        HospitalDtoOut hospitalOut = new HospitalDtoOut(hospital);

        doReturn(hospitalOut)
            .when(service).novaInstituicao(in);

        HospitalDtoOut hospitalDtoOut  = assertInstanceOf(HospitalDtoOut.class,service.novaInstituicao(in));

        assertEquals("generic hospital", hospitalDtoOut.getNome());
    
    }

    @Test
    void CaseTestErrorInCreateWithAHospital(){
        
        HospitalDtoIn in1 = new HospitalDtoIn(null, new ArrayList<>());
        HospitalDtoIn in2 = new HospitalDtoIn("", new ArrayList<>());
        HospitalDtoIn in3 = new HospitalDtoIn("18010l´´", new ArrayList<>());

        // testar campos são nulos
        Error errorFieldsNull = assertThrows(Error.class,() -> service2.novaInstituicao(in1));

        // testar campos são vazios
        Error errorInFieldsBlancks = assertThrows(Error.class,() -> service2.novaInstituicao(in2));

        // testar campos que possuem que tem caracteres especiais
        Error errorInFieldsPatternsName  = assertThrows(Error.class,() -> service2.novaInstituicao(in3));


        assertEquals("campos nulos", errorFieldsNull.getMessage());
        assertEquals("campos vazios", errorInFieldsBlancks.getMessage());
        assertEquals("campos vazios", errorInFieldsPatternsName.getMessage());
    
    }

}
