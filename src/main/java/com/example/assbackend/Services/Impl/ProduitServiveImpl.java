package com.example.assbackend.Services.Impl;


import com.example.assbackend.Dao.ProduitDao;
import com.example.assbackend.Dto.Request.ProduitReqDto;
import com.example.assbackend.Dto.Response.ProduitResDto;
import com.example.assbackend.Models.ProduitEntity;
import com.example.assbackend.Services.Facades.ProduitService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProduitServiveImpl implements ProduitService {

    ProduitDao produitDao;
    ModelMapper modelMapper;

    public ProduitServiveImpl( ProduitDao produitDao, ModelMapper modelMapper) {
        this.produitDao = produitDao;
        this.modelMapper = modelMapper;

    }

    @Override
    public ProduitResDto createProduit(ProduitReqDto produitReqDto) {

        ProduitEntity produitEntity = modelMapper.map(produitReqDto, ProduitEntity.class);
        ProduitEntity saveProd = produitDao.save(produitEntity);
        return modelMapper.map(saveProd, ProduitResDto.class);
    }

    @Override
    public ProduitResDto findProduitById(int id) {
        ProduitEntity produitEntity = produitDao.findById(id).get();
        return this.modelMapper.map(produitEntity, ProduitResDto.class);
    }

    @Override
    public void deleteProduit(int id) {
        ProduitEntity produitEntity = this.produitDao.findById(id).get();
        this.produitDao.delete(produitEntity);
    }


    @Override
    public ProduitResDto updateProduit(ProduitReqDto produitReqDto, Integer id) {
        Optional<ProduitEntity> produitEntityOptional = this.produitDao.findById(id);
        if(produitEntityOptional.isPresent()) {
            ProduitEntity produitEntity = modelMapper.map(produitReqDto, ProduitEntity.class);
            ProduitEntity updProd = produitDao.save(produitEntity);
            return modelMapper.map(updProd, ProduitResDto.class);
        }else {
            throw new EntityNotFoundException("produit pas trouve");
        }
    }

    @Override
    public List<ProduitResDto> getAllProduits() {
        return produitDao.findAll().stream()
                .map(el-> modelMapper.map(el, ProduitResDto.class))
                .collect(Collectors.toList());
    }

}
