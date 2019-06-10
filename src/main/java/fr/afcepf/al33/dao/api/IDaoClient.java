package fr.afcepf.al33.dao.api;

import fr.afcepf.al33.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoClient extends JpaRepository<Client, Integer> {
}
