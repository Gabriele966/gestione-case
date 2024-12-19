package com.example.gestione_case.DTO;

import java.util.List;

public class ProprietarioDTO {
    private Integer idProprietario;
    private String cognome;
    private String nome;
    private List<ImmobileDTO> immobileDTOList;


    public Integer getIdProprietario() {return idProprietario;}
    public void setIdProprietario(Integer idProprietario) {this.idProprietario = idProprietario;}

    public String getCognome() {return cognome;}
    public void setCognome(String cognome) {this.cognome = cognome;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public List<ImmobileDTO> getImmobileDTOList() {return immobileDTOList;}
    public void setImmobileDTOList(List<ImmobileDTO> immobileDTOList) {this.immobileDTOList = immobileDTOList;}
}
