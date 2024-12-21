package com.example.assbackend.Controllers;


import com.example.assbackend.Dto.Request.ProduitReqDto;
import com.example.assbackend.Dto.Response.ProduitResDto;
import com.example.assbackend.Services.Facades.ProduitService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produit")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("")
    public ResponseEntity<List<ProduitResDto>> getproduit(){
        return new ResponseEntity<>(produitService.getAllProduits(), HttpStatus.OK);
    }
    @PostMapping("/addproduit")
    public ResponseEntity<ProduitResDto> saveproduit(@RequestBody ProduitReqDto produitReqDto){
        ProduitResDto produitResDto = produitService.createProduit(produitReqDto);
        return new ResponseEntity<>(produitResDto, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProduitResDto> getproduitById(@PathVariable("id") Integer id){

        ProduitResDto produitResDto = produitService.findProduitById(id);
        return new ResponseEntity<>(produitResDto, HttpStatus.OK);
    }


    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteproduitById(@PathVariable("id") Integer id){
        produitService.deleteProduit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<ProduitResDto> updateproduitById(@PathVariable("id") Integer id, @RequestBody ProduitReqDto produitReqDto){
        ProduitResDto produitResDto = produitService.updateProduit(produitReqDto, id);
        return new ResponseEntity<>(produitResDto, HttpStatus.OK);
    }

}
