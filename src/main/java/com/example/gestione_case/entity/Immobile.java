package com.example.gestione_case.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Immobile")
public class Immobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idi;
    @ManyToOne
    @JoinColumn(name = "xidP")
    private Proprietario proprietario;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "vani")
    private Integer vani;
    @Column(name = "costo")
    private Integer costo;
    @Column(name = "sup")
    private Integer superfice;
    @Column(name = "anno")
    private Integer anno;
    @OneToMany (mappedBy = "immobile") // nome attributo nella classe
    private List<Annessi> listaAnnessi;


    public Integer getIdi() {return idi;}
    public void setIdi(Integer idI) {this.idi = idI;}

    public Proprietario getProprietario() {return proprietario;}
    public void setProprietario(Proprietario xidP) {this.proprietario = xidP;}

    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public Integer getVani() {return vani;}
    public void setVani(Integer vani) {this.vani = vani;}

    public Integer getCosto() {return costo;}
    public void setCosto(Integer costo) {this.costo = costo;}

    public Integer getSuperfice() {return superfice;}
    public void setSuperfice(Integer superfice) {this.superfice = superfice;}

    public Integer getAnno() {return anno;}
    public void setAnno(Integer anno) {this.anno = anno;}

    public List<Annessi> getListaAnnessi() {return listaAnnessi;}
    public void setListaAnnessi(List<Annessi> listaAnnessi) {this.listaAnnessi = listaAnnessi;}
}
