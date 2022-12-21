package tn.esprit.khairislimanitest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khairislimanitest.entities.Stock;
import tn.esprit.khairislimanitest.services.IStockService;

import java.util.List;

@RestController
@RequestMapping("stock") //http://localhost:8080/stock
public class StockRestController {
    @Autowired
    IStockService iStockService;

    @GetMapping()
    public List<Stock> retrieveAllStocks()
    {
        return iStockService.retrieveAllStocks();
    }

    @PostMapping()
    public Stock addStock(@RequestBody Stock s)
    {
        return  iStockService.addStock(s);
    }

    @PutMapping()
    public Stock updateStock(@RequestBody Stock s)
    {
        return  iStockService.updateStock(s);
    }

    @GetMapping("/{idStock}")
    public Stock retrieveStock(@PathVariable(value = "idStock") long idStock)
    {
        return iStockService.retrieveStock(idStock);
    }
    @PostMapping("/{idProduit}/{idStock}")
    public void assignProduitToStock(@PathVariable(value = "idProduit") Long idProduit, @PathVariable(value = "idStock") Long idStock)
    {
        iStockService.assignProduitToStock(idProduit,idStock);
    }


}
