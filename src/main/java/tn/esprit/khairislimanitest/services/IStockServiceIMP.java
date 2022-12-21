package tn.esprit.khairislimanitest.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.khairislimanitest.entities.Produit;
import tn.esprit.khairislimanitest.entities.Stock;
import tn.esprit.khairislimanitest.repositories.ProduitRepository;
import tn.esprit.khairislimanitest.repositories.StockRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IStockServiceIMP implements IStockService {

    StockRepository stockRepository;
    ProduitRepository produitRepository;

    @Override
    public List<Stock> retrieveAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock addStock(Stock s) {
        return stockRepository.save(s);
    }

    @Override
    public Stock updateStock(Stock u) {
        return stockRepository.save(u);
    }

    @Override
    public Stock retrieveStock(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit p = produitRepository.findById(idProduit).orElse(null);
        Stock s = stockRepository.findById(idStock).orElse(null);
        if(p != null && s != null){
            s.getProduits().add(p);
            stockRepository.save(s);
        }
    }

}
