package tn.esprit.khairislimanitest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.khairislimanitest.entities.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
}
