package tn.esprit.khairislimanitest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.khairislimanitest.entities.Client;
import tn.esprit.khairislimanitest.repositories.ClientRepository;

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
        clientRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public Client retrieveClient(Long id) {
        return clientRepository.findById(Math.toIntExact(id)).orElse(null);
    }
}
