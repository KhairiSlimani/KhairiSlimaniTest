package tn.esprit.khairislimanitest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khairislimanitest.entities.Client;
import tn.esprit.khairislimanitest.entities.Produit;
import tn.esprit.khairislimanitest.services.IFactureService;
import tn.esprit.khairislimanitest.services.IProduitService;

import java.util.List;

@RestController
@RequestMapping("produit") //http://localhost:8080/produit
public class ProduitRestController {

    @Autowired
    IProduitService iProduitService;

    @GetMapping()
    public List<Produit> retrieveAllProduits()
    {
        return iProduitService.retrieveAllProduits();
    }

    @PostMapping("/{idRayon}/{idStock}")
    public Produit addProduit(@RequestBody  Produit p, @PathVariable(value = "idRayon") Long idRayon, @PathVariable(value = "idStock") Long idStock){
        return iProduitService.addProduit(p,idRayon,idStock);
    }

    @GetMapping("/{idProduit}")
    public Produit retrieveProduit(@PathVariable(value = "idProduit") long idProduit)
    {
        return iProduitService.retrieveProduit(idProduit);
    }

    @PostMapping("/{idProduit}/{idStock}")
    public void assignProduitToStock(@PathVariable(value = "idProduit") Long idProduit, @PathVariable(value = "idStock") Long idStock)
    {
        iProduitService.assignProduitToStock(idProduit,idStock);
    }
}
