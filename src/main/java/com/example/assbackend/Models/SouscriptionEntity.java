package com.example.assbackend.Models;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="souscription")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class SouscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer souscriptionId;

    @Column(nullable=false)
    private Date dateSouscription;

    @Column(nullable=false)
    private Date dateDebutCouverture;

    @Column(nullable=false)
    private Date dateFinCouverture;

    @Column(nullable=false)
    private BigDecimal montantTotal;

    @Column(nullable=false)
    private String referenceProduit;

    @Column(nullable=false)
    private String referenceUtilisateur;
}
