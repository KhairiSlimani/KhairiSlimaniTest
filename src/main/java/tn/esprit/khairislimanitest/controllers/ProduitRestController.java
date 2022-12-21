package tn.esprit.khairislimanitest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khairislimanitest.entities.Produit;
import tn.esprit.khairislimanitest.services.IProduitService;

import java.util.Date;
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

    @PostMapping("/{fournisseurId}/{produitId}")
    public void assignFournisseurToProduit(@PathVariable(value = "fournisseurId") Long fournisseurId, @PathVariable(value = "produitId") Long produitId)
    {
        iProduitService.assignFournisseurToProduit(fournisseurId, produitId);
    }
    @GetMapping("/{idProduit}/{startDate}/{endDate}")
    public float getRevenuBrutProduit(@PathVariable(value = "idProduit") Long idProduit,@PathVariable(value = "startDate") Date startDate,@PathVariable(value = "endDate") Date endDate)
    {
        return iProduitService.getRevenuBrutProduit(idProduit,startDate,endDate);
    }
}
