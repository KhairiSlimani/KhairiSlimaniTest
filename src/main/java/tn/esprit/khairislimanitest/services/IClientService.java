package tn.esprit.khairislimanitest.services;

import tn.esprit.khairislimanitest.entities.CategorieClient;
import tn.esprit.khairislimanitest.entities.Client;

import java.util.Date;
import java.util.List;

public interface IClientService {
    List<Client> retrieveAllClients();
    Client addClient(Client c);
    void deleteClient(Long id);
    Client updateClient(Client c);
    Client retrieveClient(Long id);
    float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate);

    }
