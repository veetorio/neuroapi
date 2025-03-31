package com.ceuma.neuroapi.adapters.outbound.dto.hospital;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



/*
 * HospitalDto uma super classe responsavel por caracterizar DTOS com caracteristica do Hospital
 */
@Getter
@Setter
@AllArgsConstructor
public class HospitalDto {
    private String nome;
}
