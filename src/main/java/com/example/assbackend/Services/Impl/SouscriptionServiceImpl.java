package com.example.assbackend.Services.Impl;

import com.example.assbackend.Dao.SouscriptionDao;
import com.example.assbackend.Dto.Request.SouscriptionReqDto;
import com.example.assbackend.Dto.Response.SouscriptionResDto;
import com.example.assbackend.Models.SouscriptionEntity;
import com.example.assbackend.Services.Facades.SouscriptionService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SouscriptionServiceImpl implements SouscriptionService {

    SouscriptionDao souscriptionDao;
    ModelMapper modelMapper;
    @Override
    public SouscriptionResDto createSouscription(SouscriptionReqDto souscriptionReqDto) {

        SouscriptionEntity souscriptionEntity = modelMapper.map(souscriptionReqDto, SouscriptionEntity.class);
        SouscriptionEntity saveSous = souscriptionDao.save(souscriptionEntity);
        return modelMapper.map(saveSous, SouscriptionResDto.class);
    }

    @Override
    public SouscriptionResDto getSouscriptionById(int id) {

        SouscriptionEntity souscriptionEntity = souscriptionDao.getById(id);
        return modelMapper.map(souscriptionEntity, SouscriptionResDto.class);
    }

    @Override
    public void deleteSouscriptionById(int id) {

        SouscriptionEntity souscriptionEntity = souscriptionDao.getById(id);
        souscriptionDao.delete(souscriptionEntity);
    }

    @Override
    public SouscriptionResDto updateSouscription(SouscriptionReqDto souscriptionReqDto, Integer id) {
        Optional<SouscriptionEntity> souscriptionEntityOptional = this.souscriptionDao.findById(id);
        if (souscriptionEntityOptional.isPresent()) {
            SouscriptionEntity souscriptionEntity = modelMapper.map(souscriptionReqDto, SouscriptionEntity.class);
            SouscriptionEntity upsous = souscriptionDao.save(souscriptionEntity);
            return modelMapper.map(upsous, SouscriptionResDto.class);
        }else{
            throw new EntityNotFoundException("souscription absente");
        }
    }

    @Override
    public List<SouscriptionResDto> getAllSouscriptions() {
        return souscriptionDao.findAll().stream().
                map(el->modelMapper.map(el, SouscriptionResDto.class)).
                collect(Collectors.toList());
    }
}
