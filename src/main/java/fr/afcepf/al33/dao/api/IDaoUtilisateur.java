package fr.afcepf.al33.dao.api;

import fr.afcepf.al33.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoUtilisateur extends JpaRepository<Utilisateur, Integer> {

    public boolean existsByLogin(String login);

    public boolean existsByEmail(String mail);

}
