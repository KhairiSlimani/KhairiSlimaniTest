package tn.esprit.khairislimanitest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khairislimanitest.entities.Client;
import tn.esprit.khairislimanitest.entities.Facture;
import tn.esprit.khairislimanitest.services.IFactureService;

import java.util.List;

@RestController
@RequestMapping("facture") //http://localhost:8080/facture
public class FactureRestController {
    @Autowired
    IFactureService iFactureService;

    @GetMapping()
    public List<Facture> retrieveAllFactures()
    {
        return iFactureService.retrieveAllFactures();
    }

    @DeleteMapping("/{idFacture}")
    public void cancelFacture(@PathVariable(value = "idFacture") long idFacture)
    {
        iFactureService.cancelFacture(idFacture);
    }

    @GetMapping("/{idFacture}")
    public Facture retrieveFacture(@PathVariable(value = "idFacture") long idFacture)
    {
        return iFactureService.retrieveFacture(idFacture);
    }



}
