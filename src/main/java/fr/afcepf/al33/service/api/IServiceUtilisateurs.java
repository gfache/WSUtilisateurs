package fr.afcepf.al33.service.api;

import fr.afcepf.al33.entities.Admin;
import fr.afcepf.al33.entities.Client;
import fr.afcepf.al33.entities.Utilisateur;

import java.util.List;

public interface IServiceUtilisateurs {

    Client ajouterClient(Client client);
    void desinscrireClient(Integer idClient);
    Client modifierClient(Client client);
    List<Client> getAllClient();
    Client getClientById(Integer id);
    Admin getAdminById(Integer id);
    boolean existeMail(String mail);
    boolean existeLogin(String login);
}
