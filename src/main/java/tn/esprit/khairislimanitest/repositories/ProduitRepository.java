package tn.esprit.khairislimanitest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.khairislimanitest.entities.Produit;


public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}
