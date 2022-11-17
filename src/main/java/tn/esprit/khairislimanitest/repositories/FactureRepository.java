package tn.esprit.khairislimanitest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.khairislimanitest.entities.Facture;


public interface FactureRepository extends JpaRepository<Facture, Integer> {
}
