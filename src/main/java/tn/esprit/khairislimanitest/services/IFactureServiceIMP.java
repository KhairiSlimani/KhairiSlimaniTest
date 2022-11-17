package tn.esprit.khairislimanitest.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        factureRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public Facture retrieveFacture(Long id) {
        return factureRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    @Override
    public List<Facture> getFacturesByClient(Long idClient) {
        Client c = clientRepository.findById(Math.toIntExact(idClient)).orElse(null);
        if(c != null){
            return c.getFactures();
        }
        return null;
    }

}
