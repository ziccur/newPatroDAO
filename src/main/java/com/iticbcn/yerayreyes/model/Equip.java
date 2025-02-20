package com.iticbcn.yerayreyes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EQUIP")
public class Equip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equip")
    private Integer idEquip;

    @Column(name = "nom_equip", nullable = false)
    private String nomEquip;

    @Column(name = "ciutat", nullable = false)
    private String ciutat;

    @ManyToOne
    @JoinColumn(name = "id_lliga", nullable = false)
    private Lliga lliga;

    // Constructores, getters y setters

    public Equip() {
    }

    public Equip(String nomEquip, String ciutat, Lliga lliga) {
        this.nomEquip = nomEquip;
        this.ciutat = ciutat;
        this.lliga = lliga;
    }

    // Getters y Setters

    public Integer getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(Integer idEquip) {
        this.idEquip = idEquip;
    }

    public String getNomEquip() {
        return nomEquip;
    }

    public void setNomEquip(String nomEquip) {
        this.nomEquip = nomEquip;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public Lliga getLliga() {
        return lliga;
    }

    public void setLliga(Lliga lliga) {
        this.lliga = lliga;
    }

    @Override
    public String toString() {
        return "Equip{" +
                "idEquip=" + idEquip +
                ", nomEquip='" + nomEquip + '\'' +
                ", ciutat='" + ciutat + '\'' +
                ", lliga=" + (lliga != null ? lliga.getIdLliga() : "null") +
                '}';
    }
}