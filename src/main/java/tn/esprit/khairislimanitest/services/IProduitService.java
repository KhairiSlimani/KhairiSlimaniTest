package tn.esprit.khairislimanitest.services;

import tn.esprit.khairislimanitest.entities.Produit;

import java.util.List;

public interface IProduitService {

    List<Produit> retrieveAllProduits();

    Produit addProduit(Produit p, Long idRayon, Long idStock);

    Produit retrieveProduit(Long id);

    public void assignProduitToStock(Long idProduit, Long idStock);
}
