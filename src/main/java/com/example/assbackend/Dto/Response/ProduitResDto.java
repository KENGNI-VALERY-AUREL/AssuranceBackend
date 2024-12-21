package com.example.assbackend.Dto.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitResDto {

    private int produitId;
    private String produitName;
    private String produitRef;
    private String produitDescription;
    private BigDecimal produitPrice;

}
