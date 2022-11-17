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
    public List<Stock> retrieveAllClients()
    {
        return iStockService.retrieveAllStocks();
    }

    @PostMapping()
    public Stock addClient (@RequestBody Stock s)
    {
        return  iStockService.addStock(s);
    }

    @PutMapping()
    public Stock updateClient(@RequestBody Stock s)
    {
        return  iStockService.updateStock(s);
    }

    @GetMapping("/{idStock}")
    public Stock retrieveClient(@PathVariable(value = "idStock") long idStock)
    {
        return iStockService.retrieveStock(idStock);
    }


}
