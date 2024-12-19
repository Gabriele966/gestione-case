package com.example.gestione_case.DTO;

import com.example.gestione_case.entity.Immobile;

public class AnnessiDTO {

    private Integer id;
    private Integer idImmobile;
    private String tipo;
    private Integer sup;

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Integer getidImmobile() {return idImmobile;}
    public void setidImmobile(Integer idImmobile) {this.idImmobile = idImmobile;}

    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public Integer getSup() {return sup;}
    public void setSup(Integer sup) {this.sup = sup;}
}
