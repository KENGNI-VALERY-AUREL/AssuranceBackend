package com.example.assbackend.Services.Facades;

import com.example.assbackend.Dto.Request.SouscriptionReqDto;
import com.example.assbackend.Dto.Response.SouscriptionResDto;

import java.util.List;

public interface SouscriptionService {
    SouscriptionResDto createSouscription(SouscriptionReqDto souscriptionReqDto);

    SouscriptionResDto getSouscriptionById(int id);

    void deleteSouscriptionById(int id);

    SouscriptionResDto updateSouscription(SouscriptionReqDto souscriptionReqDto, Integer id);

    List<SouscriptionResDto> getAllSouscriptions();
}
