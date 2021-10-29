package com.bike.controller;

import com.bike.model.Bike;
import com.bike.model.Client;
import com.bike.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/Bike")
public class BikeController {
    @GetMapping("/holaMundo")
    public String saludad() {
    return "hola Mundo";
    }

    
    @Autowired
    private BikeService bikeService;
    @GetMapping("/all")
    public List<Bike> getBike(){
        return bikeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Bike> getOrthesis(@PathVariable("id") int idBike) {
        return bikeService.getBike(idBike);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike save(@RequestBody Bike bike) {
        return bikeService.save(bike);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike update (@RequestBody Bike bike) {
        return bikeService.update(bike);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id) {
        return bikeService.deleteBike(id);
    }
}   
