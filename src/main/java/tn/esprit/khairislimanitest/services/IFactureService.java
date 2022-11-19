package tn.esprit.khairislimanitest.services;

import tn.esprit.khairislimanitest.entities.Facture;

import java.util.List;

public interface IFactureService {
    List<Facture> retrieveAllFactures();
    void cancelFacture(Long id);
    Facture retrieveFacture(Long id);
    List<Facture> getFacturesByClient(Long idClient);
    Facture addFacture(Facture f, Long idClient);

}
