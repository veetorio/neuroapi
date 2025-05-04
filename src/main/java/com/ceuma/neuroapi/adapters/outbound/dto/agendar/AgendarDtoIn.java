package com.ceuma.neuroapi.adapters.outbound.dto.agendar;


import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class AgendarDtoIn {

    private LocalDate dataDeConsulta;

    private Long residente;

    private Long paciente;
}
