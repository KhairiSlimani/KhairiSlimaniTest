package tn.esprit.khairislimanitest.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.khairislimanitest.entities.Client;
import tn.esprit.khairislimanitest.entities.Facture;
import tn.esprit.khairislimanitest.repositories.ClientRepository;
import tn.esprit.khairislimanitest.repositories.FactureRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IFactureServiceIMP implements IFactureService{

    FactureRepository factureRepository;
    ClientRepository clientRepository;

    @Override
    public List<Facture> retrieveAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public void cancelFacture(Long id) {
        Facture facture= factureRepository.findById(id).orElse(null);
        facture.setActive(false);
    }

    @Override
    public Facture retrieveFacture(Long id) {
        return factureRepository.findById(id).orElse(null);
    }

    @Override
    public List<Facture> getFacturesByClient(Long idClient) {
        Client c = clientRepository.findById(idClient).orElse(null);
        if(c != null){
            return c.getFactures();
        }
        return null;
    }
    @Override
    public Facture addFacture(Facture f, Long idClient) {
        Client client = clientRepository.findById(idClient).orElse(null);
        if(client != null)
            f.setClient(client);
        return null;
    }


}
