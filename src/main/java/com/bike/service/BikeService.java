package com.bike.service;
import com.bike.model.Bike;
import com.bike.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getAll(){
        return bikeRepository.getAll();
    }

    public Optional<Bike> getBike(int id) {
        return bikeRepository.getBike(id);
    }

    public Bike save(Bike bike){
        if(bike.getId()==null){
            return bikeRepository.save(bike);
        }else{
            Optional<Bike> e= bikeRepository.getBike(bike.getId());
            if(e.isEmpty()){
                return bikeRepository.save(bike);
            }else{
                return bike;
            }
        }
    }
}

