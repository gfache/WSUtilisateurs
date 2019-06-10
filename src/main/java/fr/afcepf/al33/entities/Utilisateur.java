package fr.afcepf.al33.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idUtilisateur", scope = Utilisateur.class)
public class Utilisateur implements Serializable {

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String email, String login, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Integer idUtilisateur;

    @Column(nullable = false, length = 50)
    protected String nom;

    @Column(nullable = false, length = 50)
    protected String prenom;

    @Column(nullable = false, length = 100)
    protected String email;

    @Column(nullable = false, length = 30)
    protected String login;

    @Column(nullable = false, length = 30)
    protected String password;

    @ManyToOne
    @JoinColumn(name="idCivilite")
    private Civilite civilite;

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}