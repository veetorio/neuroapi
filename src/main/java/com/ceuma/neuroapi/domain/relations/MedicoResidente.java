package com.ceuma.neuroapi.domain.relations;

import java.util.List;

import com.ceuma.neuroapi.adapters.outbound.dto.medicoresidente.MedicoResidenteIn;
import com.ceuma.neuroapi.domain.models.Hospital;
import com.ceuma.neuroapi.domain.models.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
public class MedicoResidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean statusResidente;

    @ManyToOne
    @JoinColumn(name = "fk_hospital")
    private Hospital fk_hospital;

    @ManyToOne
    @JoinColumn(name = "fk_medico")
    private Usuario fk_medico;

    @ManyToOne
    @JoinColumn(name = "fk_residente")
    private Usuario fk_residente;

    @OneToMany(mappedBy = "fk_Consulta_residente_medico")
    private List<Consulta> consultas;

    public MedicoResidente(Boolean statusResidente, Hospital fk_hospital, Usuario fk_medico, Usuario fk_residente) {
        this.statusResidente = statusResidente;
        this.fk_hospital = fk_hospital;
        this.fk_medico = fk_medico;
        this.fk_residente = fk_residente;
    }
    public MedicoResidente(MedicoResidenteIn mrIn) {
        this.statusResidente = mrIn.getStatus();
    }


    
    
}
