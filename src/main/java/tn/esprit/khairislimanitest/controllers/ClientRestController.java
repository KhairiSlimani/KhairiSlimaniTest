package tn.esprit.khairislimanitest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khairislimanitest.entities.Client;
import tn.esprit.khairislimanitest.services.IClientService;

import java.util.List;

@RestController
@RequestMapping("client") //http://localhost:8080/client
public class ClientRestController {
    @Autowired
    IClientService iClientService;

    @GetMapping()
    public List<Client> retrieveAllClients()
    {
        return iClientService.retrieveAllClients();
    }

    @PostMapping()
    public Client addClient (@RequestBody Client c)
    {
        return  iClientService.addClient(c);
    }

    @PutMapping()
    public Client updateClient(@RequestBody Client c)
    {
        return  iClientService.updateClient(c);
    }

    @GetMapping("/{idClient}")
    public Client retrieveClient(@PathVariable(value = "idClient") long idClient)
    {
        return iClientService.retrieveClient(idClient);
    }

    @DeleteMapping("/{idClient}")
    public void deleteClient(@PathVariable(value = "idClient") long idClient)
    {
        iClientService.deleteClient(idClient);
    }

}
