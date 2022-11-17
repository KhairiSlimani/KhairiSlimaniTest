package tn.esprit.khairislimanitest.services;

import tn.esprit.khairislimanitest.entities.Stock;

import java.util.List;

public interface IStockService {
    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock u);

    Stock retrieveStock(Long id);

}
