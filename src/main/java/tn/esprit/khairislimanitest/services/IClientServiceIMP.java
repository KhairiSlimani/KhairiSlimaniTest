package tn.esprit.khairislimanitest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.khairislimanitest.entities.CategorieClient;
import tn.esprit.khairislimanitest.entities.Client;
import tn.esprit.khairislimanitest.entities.Facture;
import tn.esprit.khairislimanitest.repositories.ClientRepository;

import java.util.Date;
import java.util.List;

@Service
public class IClientServiceIMP implements IClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public Client retrieveClient(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {

        List<Client> clients = clientRepository.getClientsByCategorieClient(categorieClient);

        float summ=0;
        for(Client c: clients){
            for(Facture facture: c.getFactures()){
                if(facture.getDateFacture().after(startDate) &&facture.getDateFacture().before(endDate)){
                    if(facture.isActive()) {
                        summ+=facture.getMontantFacture();
                    }
                }
            }
        }
        return summ;
    }


}
