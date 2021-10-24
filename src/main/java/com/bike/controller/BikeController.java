package com.bike.controller;

import com.bike.model.Bike;
import com.bike.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/Bike")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class BikeController {

    @Autowired
    private BikeService bikeService;
    @GetMapping("/all")
    public List<Bike> getAll(){
        return bikeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Bike> getBike(@PathVariable("id") int id) {
        return bikeService.getBike(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike save(@RequestBody Bike bike) {
        return bikeService.save(bike);
    }
}   
