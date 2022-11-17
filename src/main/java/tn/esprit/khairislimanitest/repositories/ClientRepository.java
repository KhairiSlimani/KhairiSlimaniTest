package tn.esprit.khairislimanitest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.khairislimanitest.entities.Client;


public interface ClientRepository extends JpaRepository<Client, Integer> {
}
