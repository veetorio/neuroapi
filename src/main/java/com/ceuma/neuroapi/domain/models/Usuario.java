package com.ceuma.neuroapi.domain.models;

import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.usuario.UsuarioDtoIn;
import com.ceuma.neuroapi.domain.relations.MedicoResidente;
import com.ceuma.neuroapi.utils.enums.TipoUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    @Column(length = 80,nullable = true)
    private String email;

    @Column(nullable = true)
    private String senha;

    @Column(length = 60,nullable = true)
    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    // medicosresidentes tem muitas instancias de medicos
    @OneToMany(mappedBy = "fk_medico")
    List<MedicoResidente> medicos;

    // medicosresidentes tem uma muitas instancias de residente
    @OneToMany(mappedBy = "fk_residente")
    List<MedicoResidente> residentes;

    // construtor para criar usuario a partir de um usuario DtoIn
    public Usuario(UsuarioDtoIn usuarioDtoIn) {
        this.email = usuarioDtoIn.getEmail();
        this.senha = usuarioDtoIn.getSenha();
        this.nome = usuarioDtoIn.getNome() ;
        this.tipoUsuario = usuarioDtoIn.getTipo();
    }

    
}