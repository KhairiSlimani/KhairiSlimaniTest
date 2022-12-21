package tn.esprit.khairislimanitest.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetailProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailProduit;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @Temporal(TemporalType.DATE)
    private Date dateDerniereModification;

    @Enumerated(EnumType.STRING)
    private CategorieProduit categorieProduit;

    @OneToOne
    private Produit produit;


}
