package fr.afcepf.al33.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idUtilisateur", scope = Utilisateur.class)
public class Admin extends Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

    public Admin() {
    }

    public Admin(String nom, String prenom, String email, String login, String password) {
        super(nom, prenom, email, login, password);
    }
}