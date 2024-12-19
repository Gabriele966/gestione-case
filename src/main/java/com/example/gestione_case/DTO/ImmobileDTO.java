package com.example.gestione_case.DTO;



import java.util.List;

public class ImmobileDTO {

    private Integer idImmobile;
    private Integer idProprietario;
    private String tipo;
    private Integer vani;
    private Integer costo;
    private Integer superfice;
    private Integer anno;
    private List<AnnessiDTO> listaAnnessi;

    public Integer getIdImmobile() {return idImmobile;}
    public void setIdImmobile(Integer idImmobile) {this.idImmobile = idImmobile;}

    public Integer getIdProprietario() {return idProprietario;}
    public void setIdProprietario(Integer idProprietario) {this.idProprietario = idProprietario;}

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

    public List<AnnessiDTO> getListaAnnessi() {return listaAnnessi;}
    public void setListaAnnessi(List<AnnessiDTO> listaAnnessi) {this.listaAnnessi = listaAnnessi;}
}

