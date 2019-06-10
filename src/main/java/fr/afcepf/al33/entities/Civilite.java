package fr.afcepf.al33.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * 
 */
@Entity
@Table
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idCivilite", scope = Civilite.class)
public class Civilite implements Serializable {
	private static final long serialVersionUID = 1L;

    public Civilite() {
    }

    public Civilite(String libelle) {
        this.libelle = libelle;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCivilite;

    @Column(nullable = false, length = 15)
    private String libelle;

    @OneToMany(mappedBy="civilite")
    @JsonIgnore
    private Set<Utilisateur> utilisateurs;

    public Integer getIdCivilite() {
        return idCivilite;
    }

    public void setIdCivilite(Integer idCivilite) {
        this.idCivilite = idCivilite;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Set<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}