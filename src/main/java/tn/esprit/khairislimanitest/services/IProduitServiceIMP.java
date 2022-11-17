package tn.esprit.khairislimanitest.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.khairislimanitest.entities.Fournisseur;
import tn.esprit.khairislimanitest.entities.Produit;
import tn.esprit.khairislimanitest.entities.Rayon;
import tn.esprit.khairislimanitest.entities.Stock;
import tn.esprit.khairislimanitest.repositories.FournisseurRepository;
import tn.esprit.khairislimanitest.repositories.ProduitRepository;
import tn.esprit.khairislimanitest.repositories.RayonRepository;
import tn.esprit.khairislimanitest.repositories.StockRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IProduitServiceIMP implements IProduitService{

    ProduitRepository produitRepository;
    StockRepository stockRepository;
    RayonRepository rayonRepository;
    FournisseurRepository fournisseurRepository;

    @Override
    public List<Produit> retrieveAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idRayon, Long idStock) {

        Rayon rayon = rayonRepository.findById(Math.toIntExact(idRayon)).orElse(null);
        Stock stock = stockRepository.findById(Math.toIntExact(idStock)).orElse(null);

        p.setRayon(rayon);
        p.setStock(stock);

        produitRepository.save(p);

        return p;

    }

    @Override
    public Produit retrieveProduit(Long id) {
        return produitRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit p = produitRepository.findById(Math.toIntExact(idProduit)).orElse(null);
        Stock s = stockRepository.findById(Math.toIntExact(idStock)).orElse(null);
        if(p != null && s != null){
            p.setStock(s);
            produitRepository.save(p);
        }
    }

    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
        Fournisseur f = fournisseurRepository.findById(Math.toIntExact(fournisseurId)).orElse(null);
        Produit p = produitRepository.findById(Math.toIntExact(produitId)).orElse(null);
        if(f != null && p != null){
            p.getFournisseurs().add(f);
            produitRepository.save(p);
        }
    }



}
