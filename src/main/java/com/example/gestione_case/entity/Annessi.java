package com.example.gestione_case.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Annessi")
public class Annessi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "xidI") // nome Colonna nel di usata per il join
    private Immobile immobile;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "sup")
    private Integer sup;


    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Immobile getImmobile() {return immobile;}
    public void setImmobile(Immobile immobile) {this.immobile = immobile;}

    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public Integer getSup() {return sup;}
    public void setSup(Integer sup) {this.sup = sup;}
}
