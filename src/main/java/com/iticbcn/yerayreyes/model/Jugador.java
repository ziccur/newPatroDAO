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
@Table(name = "JUGADOR")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    private Long idJugador;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "cognoms", nullable = false)
    private String cognoms;

    @ManyToOne
    @JoinColumn(name = "id_equip", nullable = true)
    private Equip equip;

    // Constructores, getters y setters

    public Jugador() {
    }

    public Jugador(String nom, String cognoms, Equip equip) {
        this.nom = nom;
        this.cognoms = cognoms;
        this.equip = equip;
    }

    // Getters y Setters

    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador = idJugador;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public Equip getEquip() {
        return equip;
    }

    public void setEquip(Equip equip) {
        this.equip = equip;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "idJugador=" + idJugador +
                ", nom='" + nom + '\'' +
                ", cognoms='" + cognoms + '\'' +
                ", equip=" + (equip != null ? equip.getIdEquip() : "null") +
                '}';
    }
}