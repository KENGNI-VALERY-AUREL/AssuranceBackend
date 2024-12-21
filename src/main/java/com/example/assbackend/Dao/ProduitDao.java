package com.example.assbackend.Dao;


import com.example.assbackend.Models.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProduitDao extends JpaRepository<ProduitEntity, Integer> {

}
