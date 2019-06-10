package fr.afcepf.al33.dao.api;

import fr.afcepf.al33.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDaoAdmin extends JpaRepository<Admin, Integer> {
}
