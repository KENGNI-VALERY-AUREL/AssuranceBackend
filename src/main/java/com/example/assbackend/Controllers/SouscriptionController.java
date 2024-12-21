package com.example.assbackend.Controllers;
import com.example.assbackend.Dto.Request.SouscriptionReqDto;
import com.example.assbackend.Dto.Response.SouscriptionResDto;
import com.example.assbackend.Services.Facades.SouscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("souscription")
public class SouscriptionController {


    private final SouscriptionService souscriptionService;

    public SouscriptionController(SouscriptionService souscriptionService) {
        this.souscriptionService = souscriptionService;
    }


    @GetMapping("")
    public ResponseEntity<List<SouscriptionResDto>> getSouscription() {
        return new ResponseEntity<>(souscriptionService.getAllSouscriptions(), HttpStatus.OK);
    }

    @PostMapping("/addsousc")
    public ResponseEntity<SouscriptionResDto> savesousc(@RequestBody SouscriptionReqDto souscriptionReqDto) {
        SouscriptionResDto souscriptionResDto = souscriptionService.createSouscription(souscriptionReqDto);
        return new ResponseEntity<>(souscriptionResDto, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<SouscriptionResDto> getSouscriptionById(@PathVariable Integer id) {
        SouscriptionResDto souscriptionResDto = souscriptionService.getSouscriptionById(id);
        return new ResponseEntity<>(souscriptionResDto, HttpStatus.OK);

    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deletesousById (@PathVariable("id") Integer id){
        souscriptionService.deleteSouscriptionById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<SouscriptionResDto> updatesosuById(@PathVariable("id") Integer id, @RequestBody SouscriptionReqDto souscriptionReqDto) {
        SouscriptionResDto souscriptionResDto = souscriptionService.updateSouscription(souscriptionReqDto,id);
        return new ResponseEntity<>(souscriptionResDto, HttpStatus.OK);
    }

}
