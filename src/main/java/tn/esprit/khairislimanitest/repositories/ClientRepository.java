package tn.esprit.khairislimanitest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.khairislimanitest.entities.CategorieClient;
import tn.esprit.khairislimanitest.entities.Client;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> getClientsByCategorieClient(CategorieClient categorieClient);
}
