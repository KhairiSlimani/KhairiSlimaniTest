package tn.esprit.khairislimanitest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.khairislimanitest.entities.Stock;
import tn.esprit.khairislimanitest.repositories.StockRepository;

import java.util.List;

@Service
public class IStockServiceIMP implements IStockService {

    @Autowired
    StockRepository stockRepository;

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
        return stockRepository.findById(Math.toIntExact(id)).orElse(null);
    }


}
