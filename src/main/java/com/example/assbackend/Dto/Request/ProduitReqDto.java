package com.example.assbackend.Dto.Request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ProduitReqDto {

    @NotBlank
    @Size(max= 15, message = "le nom doit avoir maximun 15 caractere")
    private String name;

    @NotBlank
    @Size(max= 15, message = "la reference doit avoir maximun 15 caractere")
    private String produitRef;


    @NotBlank
    @Size(max= 15, message = "la description doit avoir maximun 15 caractere")
    private String description;

    private BigDecimal montant;
}
