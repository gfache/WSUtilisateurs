package fr.afcepf.al33.service.impl;

import fr.afcepf.al33.dao.api.IDaoAdmin;
import fr.afcepf.al33.dao.api.IDaoClient;
import fr.afcepf.al33.dao.api.IDaoUtilisateur;
import fr.afcepf.al33.entities.Admin;
import fr.afcepf.al33.entities.Client;
import fr.afcepf.al33.service.api.IServiceUtilisateurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceUtilisateurs implements IServiceUtilisateurs {

    @Autowired
    private IDaoClient daoClient;

    @Autowired
    private IDaoAdmin daoAdmin;

    @Autowired
    private IDaoUtilisateur daoUtilisateur;


    @Override
    public Client ajouterClient(Client client) {
        if (daoUtilisateur.existsByEmail(client.getEmail()) || daoUtilisateur.existsByLogin(client.getLogin())) {
            return null;
        }
        System.out.println("Sauvegarde du client!!!!");
        return daoClient.save(client);
    }

    @Override
    public void desinscrireClient(Integer idClient) {
        Optional<Client> client = daoClient.findById(idClient);
        if (client.isPresent()) {
            daoClient.delete(client.get());
        }
    }

    @Override
    public Client modifierClient(Client client) {
        return daoClient.save(client);
    }

    @Override
    public List<Client> getAllClient() {
        return daoClient.findAll();
    }

    @Override
    public Client getClientById(Integer id) {
        Optional<Client> client = daoClient.findById(id);
        if (client.isPresent()) {
            return client.get();
        }
        return null;
    }

    @Override
    public Admin getAdminById(Integer id) {
        Optional<Admin> admin = daoAdmin.findById(id);
        if (admin.isPresent()) {
            return admin.get();
        }
        return null;
    }

    @Override
    public boolean existeMail(String mail) {
        return daoUtilisateur.existsByEmail(mail);
    }

    @Override
    public boolean existeLogin(String login) {
        return daoUtilisateur.existsByLogin(login);
    }
}
