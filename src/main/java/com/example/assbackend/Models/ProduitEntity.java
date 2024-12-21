package com.example.assbackend.Models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Data
@AllArgsConstructor
@Table(name = "produit")
@NoArgsConstructor
@Setter
@Getter
public class ProduitEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduit;

    @Column()
    private String nom;

    @Column (name = "reference")
    private String ref_p;

    @Column()
    private String description;

    @Column()
    private BigDecimal montant;
}
