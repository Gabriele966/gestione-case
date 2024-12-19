package com.example.gestione_case.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Proprietario")
public class Proprietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idP;
    @Column(name = "Cognome")
    private String cognome;
    @Column(name = "Nome")
    private String nome;
    @OneToMany(mappedBy = "proprietario")
    private List<Immobile> listaImmobili;


    public Integer getIdP() {return idP;}
    public void setIdP(Integer idP) {this.idP = idP;}

    public String getCognome() {return cognome;}
    public void setCognome(String cognome) {this.cognome = cognome;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public List<Immobile> getListaImmobili() {return listaImmobili;}
    public void setListaImmobili(List<Immobile> listaImmobili) {this.listaImmobili = listaImmobili;}
}
