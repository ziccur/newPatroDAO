package com.iticbcn.yerayreyes.model;

import java.io.Serializable;

public class Lliga implements Serializable {

    private Long idLliga;
    private String nomLliga;
    private String temporada;

    // Constructores
    public Lliga() {
    }

    public Lliga(String nomLliga, String temporada) {
        this.nomLliga = nomLliga;
        this.temporada = temporada;
    }

    // Getters y Setters
    public Long getIdLliga() {
        return idLliga;
    }

    public void setIdLliga(Long idLliga) {
        this.idLliga = idLliga;
    }

    public String getNomLliga() {
        return nomLliga;
    }

    public void setNomLliga(String nomLliga) {
        this.nomLliga = nomLliga;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    @Override
    public String toString() {
        return "Lliga{" +
                "idLliga=" + idLliga +
                ", nomLliga='" + nomLliga + '\'' +
                ", temporada='" + temporada + '\'' +
                '}';
    }
}