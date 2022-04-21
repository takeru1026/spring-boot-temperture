package com.example.temperture.controller;

import com.example.temperture.model.Temperture;
import com.example.temperture.services.TempertureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/temperture")
public class TempertureController {
    private final TempertureService tempertureService;

    @Autowired
    public TempertureController(TempertureService tempertureservice) {
        this.tempertureService = tempertureservice;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllTempertures(@RequestParam("N") int number) {
        return new ResponseEntity<>(tempertureService.getTempertures(number), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Temperture> saveTemperture(@RequestBody Temperture temperture) {
        Temperture newTemperture = tempertureService.insertTemperture(temperture);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("temperture", "/" + newTemperture.getId().toString());
        return new ResponseEntity<>(newTemperture, httpHeaders, HttpStatus.CREATED);
    }
}
