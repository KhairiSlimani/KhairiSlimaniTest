package tn.esprit.khairislimanitest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.khairislimanitest.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
