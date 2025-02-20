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
@Table(name = "CLASSIFICACIO")
public class Classificacio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classificacio")
    private Long idClassificacio;

    @ManyToOne
    @JoinColumn(name = "id_equip", nullable = false)
    private Equip equip;

    @Column(name = "punts", nullable = false)
    private Integer punts;

    @Column(name = "partits_jugats", nullable = false)
    private Integer partitsJugats;

    @Column(name = "victories", nullable = false)
    private Integer victories;

    // Constructores, getters y setters

    public Classificacio() {
    }

    public Classificacio(Equip equip, Integer punts, Integer partitsJugats, Integer victories) {
        this.equip = equip;
        this.punts = punts;
        this.partitsJugats = partitsJugats;
        this.victories = victories;
    }

    // Getters y Setters

    public Long getIdClassificacio() {
        return idClassificacio;
    }

    public void setIdClassificacio(Long idClassificacio) {
        this.idClassificacio = idClassificacio;
    }

    public Equip getEquip() {
        return equip;
    }

    public void setEquip(Equip equip) {
        this.equip = equip;
    }

    public Integer getPunts() {
        return punts;
    }

    public void setPunts(Integer punts) {
        this.punts = punts;
    }

    public Integer getPartitsJugats() {
        return partitsJugats;
    }

    public void setPartitsJugats(Integer partitsJugats) {
        this.partitsJugats = partitsJugats;
    }

    public Integer getVictories() {
        return victories;
    }

    public void setVictories(Integer victories) {
        this.victories = victories;
    }

    @Override
    public String toString() {
        return "Classificacio{" +
                "idClassificacio=" + idClassificacio +
                ", equip=" + (equip != null ? equip.getIdEquip() : "null") +
                ", punts=" + punts +
                ", partitsJugats=" + partitsJugats +
                ", victories=" + victories +
                '}';
    }
}