package com.example.assbackend.Services.Facades;

import com.example.assbackend.Dto.Request.ProduitReqDto;
import com.example.assbackend.Dto.Response.ProduitResDto;

import java.util.List;

public interface ProduitService {

    ProduitResDto createProduit(ProduitReqDto produitReqDto);

    ProduitResDto findProduitById(int id);

    void deleteProduit(int id);


    ProduitResDto updateProduit(ProduitReqDto produitReqDto, Integer id);

    List<ProduitResDto> getAllProduits();

}
