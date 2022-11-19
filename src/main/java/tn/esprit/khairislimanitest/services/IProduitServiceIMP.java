package tn.esprit.khairislimanitest.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.khairislimanitest.entities.*;
import tn.esprit.khairislimanitest.repositories.FournisseurRepository;
import tn.esprit.khairislimanitest.repositories.ProduitRepository;
import tn.esprit.khairislimanitest.repositories.RayonRepository;
import tn.esprit.khairislimanitest.repositories.StockRepository;

import java.util.Date;
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

        Rayon rayon = rayonRepository.findById(idRayon).orElse(null);
        Stock stock = stockRepository.findById(idStock).orElse(null);

        p.setRayon(rayon);
        p.setStock(stock);

        produitRepository.save(p);

        return p;

    }

    @Override
    public Produit retrieveProduit(Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit p = produitRepository.findById(idProduit).orElse(null);
        Stock s = stockRepository.findById(idStock).orElse(null);
        if(p != null && s != null){
            p.setStock(s);
            produitRepository.save(p);
        }
    }

    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
        Fournisseur f = fournisseurRepository.findById(fournisseurId).orElse(null);
        Produit p = produitRepository.findById(produitId).orElse(null);
        if(f != null && p != null){
            p.getFournisseurs().add(f);
            produitRepository.save(p);
        }
    }
    @Override
    public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
        Produit p = produitRepository.findById(idProduit).orElse(null);
        float r = 0;
        if(p!=null){
            List<DetailFacture> detailFactures = p.getDetailFacture();
            for(DetailFacture df: detailFactures){
                if(df.getFacture().getDateFacture().after(startDate)&&df.getFacture().getDateFacture().before(endDate))
                {
                    if(df.getFacture().isActive()) {
                        r+=df.getPrixTotal()*df.getQte();
                    }
                }
            }
        }
        return r;
    }




}
