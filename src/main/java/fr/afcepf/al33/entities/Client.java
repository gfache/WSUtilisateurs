package fr.afcepf.al33.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUtilisateur", scope = Utilisateur.class)
public class Client extends Utilisateur {
	private static final long serialVersionUID = 1L;
	
    public Client() {
    }

    @Column(length = 20)
    private String numTelPortable;

    @Column(length = 20)
    private String numTelFixe;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateNaissance;

    @Column(length = 255)
    private String motifSuspension;

    @Column(length = 255)
    private String adresse;

    @Column(length = 50)
    private String ville;

    @Column(length = 50)
    private String codePostal;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInscription;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDesinscription;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebutSuspension;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinSuspension;

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getNumTelPortable() {
        return numTelPortable;
    }

    public void setNumTelPortable(String numTelPortable) {
        this.numTelPortable = numTelPortable;
    }

    public String getNumTelFixe() {
        return numTelFixe;
    }

    public void setNumTelFixe(String numTelFixe) {
        this.numTelFixe = numTelFixe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getMotifSuspension() {
        return motifSuspension;
    }

    public void setMotifSuspension(String motifSuspension) {
        this.motifSuspension = motifSuspension;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Date getDateDesinscription() {
        return dateDesinscription;
    }

    public void setDateDesinscription(Date dateDesinscription) {
        this.dateDesinscription = dateDesinscription;
    }

    public Date getDateDebutSuspension() {
        return dateDebutSuspension;
    }

    public void setDateDebutSuspension(Date dateDebutSuspension) {
        this.dateDebutSuspension = dateDebutSuspension;
    }

    public Date getDateFinSuspension() {
        return dateFinSuspension;
    }

    public void setDateFinSuspension(Date dateFinSuspension) {
        this.dateFinSuspension = dateFinSuspension;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Client{" +
                "numTelPortable='" + numTelPortable + '\'' +
                ", numTelFixe='" + numTelFixe + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", motifSuspension='" + motifSuspension + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", dateInscription=" + dateInscription +
                ", dateDesinscription=" + dateDesinscription +
                ", dateDebutSuspension=" + dateDebutSuspension +
                ", dateFinSuspension=" + dateFinSuspension +
                ", idUtilisateur=" + idUtilisateur +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}