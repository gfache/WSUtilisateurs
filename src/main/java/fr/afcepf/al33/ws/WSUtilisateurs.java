package fr.afcepf.al33.ws;

import dtoClients.CiviliteDTO;
import dtoClients.ClientDTO;
import dtoClients.ClientListDTO;
import fr.afcepf.al33.entities.Admin;
import fr.afcepf.al33.entities.Civilite;
import fr.afcepf.al33.entities.Client;
import fr.afcepf.al33.service.api.IServiceUtilisateurs;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/rest", headers = "Accept=application/json")
public class WSUtilisateurs {

    @Autowired
    private IServiceUtilisateurs serviceUtilisateurs;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @PostMapping("/ajouter")
    public ClientDTO ajouterClient(@RequestBody ClientDTO clientDTO) {
        System.out.println(clientDTO);
        Client client = dtoToClient(clientDTO); // modelMapper().map(clientDTO, Client.class);
        client = serviceUtilisateurs.ajouterClient(client);
        System.out.println("Client ajouté");
        if (client != null) {
            System.out.println("Client to dto");
            System.out.println(client);
            ClientDTO clientDTOAjoute = clientToDTO(client);//modelMapper().map(client, ClientDTO.class);
            System.out.println(clientDTOAjoute.toString());
            return clientDTOAjoute;
        }
        return null;
    }

    @GetMapping("/ajouter/mail/{mail}")
    public boolean existMail(@PathVariable String mail) {
        return serviceUtilisateurs.existeMail(mail);
    }

    @GetMapping("/ajouter/login/{login}")
    public boolean existLogin(@PathVariable String login) {
        return serviceUtilisateurs.existeLogin(login);
    }

    @PutMapping("/modifier")
    public ClientDTO modifierClient(@RequestBody ClientDTO clientDTO) {

        //Client client = modelMapper().map(clientDTO, Client.class);
        Client client = dtoToClient(clientDTO);
        client = serviceUtilisateurs.modifierClient(client);
        if (client != null) {
            ClientDTO clientDTOModifie = clientToDTO(client);//modelMapper().map(client, ClientDTO.class);
            return clientDTOModifie;
        }
        return null;
    }

    @DeleteMapping("/desinscrire/{idClient}")
    public void desinscrireClient(@PathVariable Integer idClient) {
        serviceUtilisateurs.desinscrireClient(idClient);
    }

    @GetMapping("/client")
    public ClientListDTO getAllClient() {
        List<Client> clients = serviceUtilisateurs.getAllClient();
        List<ClientDTO> clientDTOList = new ArrayList<>();
        ClientListDTO clientListDTO = new ClientListDTO();
        for (Client client : clients) {
            ClientDTO clientDTO = modelMapper().map(client, ClientDTO.class);
            clientDTOList.add(clientDTO);
        }
        clientListDTO.setClients(clientDTOList);
        return clientListDTO;
    }

    @GetMapping("/client/{id}")
    public ClientDTO getClientById(@PathVariable Integer id) {
        Client client = serviceUtilisateurs.getClientById(id);
        if (client != null) {
            ClientDTO clientDTO = modelMapper().map(client, ClientDTO.class);
            return clientDTO;
        }
        return null;
    }

    @GetMapping("/admin/{id}")
    public ClientDTO getAdminById(@PathVariable Integer id) {
        Admin admin = serviceUtilisateurs.getAdminById(id);
        if (admin != null) {
            ClientDTO clientDTO = modelMapper().map(admin, ClientDTO.class);
            return clientDTO;
        }
        return null;
    }

    public ClientDTO clientToDTO(Client client) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNumTelFixe(client.getNumTelFixe());
        clientDTO.setNumTelPortable(client.getNumTelPortable());
        clientDTO.setMotifSuspension(client.getMotifSuspension());
        clientDTO.setAdresse(client.getAdresse());
        clientDTO.setVille(client.getVille());
        clientDTO.setCodePostal(client.getCodePostal());
        formaterDateDTO(clientDTO, client, simpleDateFormat);
        clientDTO.setIdUtilisateur(client.getIdUtilisateur());
        clientDTO.setNom(client.getNom());
        clientDTO.setPrenom(client.getPrenom());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setLogin(client.getLogin());
        clientDTO.setPassword(client.getPassword());
        if (client.getCivilite() != null) {
            CiviliteDTO civiliteDTO = new CiviliteDTO();
            civiliteDTO.setLibelle(client.getCivilite().getLibelle());
            civiliteDTO.setIdCivilite(client.getCivilite().getIdCivilite());
            clientDTO.setCivilite(civiliteDTO);
        }
        return clientDTO;
    }

    public void formaterDateDTO(ClientDTO clientDTO, Client client, SimpleDateFormat simpleDateFormat) {
        if (client.getDateNaissance() != null) {
            clientDTO.setDateNaissance(simpleDateFormat.format(client.getDateNaissance()));
        }
        if (client.getDateInscription() != null) {
            clientDTO.setDateInscription(simpleDateFormat.format(client.getDateInscription()));
        }
        if (client.getDateDebutSuspension() != null) {
            clientDTO.setDateDebutSuspension(simpleDateFormat.format(client.getDateDebutSuspension()));
        }
        if (client.getDateFinSuspension() != null) {
            clientDTO.setDateFinSuspension(simpleDateFormat.format(client.getDateFinSuspension()));
        }
        if (client.getDateDesinscription() != null) {
            clientDTO.setDateDesinscription(simpleDateFormat.format(client.getDateDesinscription()));
        }
    }

    public Client dtoToClient(ClientDTO clientDTO) {
        System.out.println(clientDTO.toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Client client = new Client();
        client.setNumTelFixe(clientDTO.getNumTelFixe());
        client.setNumTelPortable(clientDTO.getNumTelPortable());
        client.setMotifSuspension(clientDTO.getMotifSuspension());
        client.setAdresse(clientDTO.getAdresse());
        client.setVille(clientDTO.getVille());
        client.setCodePostal(clientDTO.getCodePostal());
        try {
            formaterDateEntite(client, clientDTO, simpleDateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Impossible de parser les dates du DTO!!!!");
        }
        client.setIdUtilisateur(clientDTO.getIdUtilisateur());
        client.setNom(clientDTO.getNom());
        client.setPrenom(clientDTO.getPrenom());
        client.setEmail(clientDTO.getEmail());
        client.setLogin(clientDTO.getLogin());
        client.setPassword(clientDTO.getPassword());
        if (clientDTO.getCivilite() != null) {
            Civilite civilite = new Civilite();
            civilite.setLibelle(clientDTO.getCivilite().getLibelle());
            civilite.setIdCivilite(clientDTO.getCivilite().getIdCivilite());
            client.setCivilite(civilite);
        }
        System.out.println(client.toString());
        return client;
    }

    public void formaterDateEntite(Client client, ClientDTO clientDTO, SimpleDateFormat simpleDateFormat) throws ParseException {
        if (clientDTO.getDateNaissance() != null) {
            client.setDateNaissance(simpleDateFormat.parse(clientDTO.getDateNaissance()));
        }
        if (clientDTO.getDateInscription() != null) {
            client.setDateInscription(simpleDateFormat.parse(clientDTO.getDateInscription()));
        }
        if (clientDTO.getDateDesinscription() != null) {
            client.setDateNaissance(simpleDateFormat.parse(clientDTO.getDateNaissance()));
        }
        if (clientDTO.getDateDebutSuspension() != null) {
            client.setDateDebutSuspension(simpleDateFormat.parse(clientDTO.getDateDebutSuspension()));
        }
        if (clientDTO.getDateFinSuspension() != null) {
            client.setDateDebutSuspension(simpleDateFormat.parse(clientDTO.getDateDebutSuspension()));
        }
    }
}
