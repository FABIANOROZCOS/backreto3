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
    private BikeRepository metodosCrud;

    public List<Bike> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Bike> getBike(int idBike) {
        return metodosCrud.getBike(idBike);
    }

    public Bike save(Bike bike){
        if(bike.getId()==null){
            return metodosCrud.save(bike);
        }else{
            Optional<Bike> e= metodosCrud.getBike(bike.getId());
            if(e.isEmpty()){
                return metodosCrud.save(bike);
            }else{
                return bike;
            }
        }
    }
    public Bike update (Bike bike){
        if(bike.getId()!=null){
            Optional<Bike> e=metodosCrud.getBike(bike.getId());
            if(!e.isEmpty()){
                 if(bike.getId()!=null){
                    e.get().setId(bike.getId());
                }
                if(bike.getName()!=null){
                    e.get().setName(bike.getName());
                }
                if(bike.getBrand()!=null){
                    e.get().setBrand(bike.getBrand());
                }
                if(bike.getYear()!=null){
                    e.get().setYear(bike.getYear());
                }
                if(bike.getDescription()!=null){
                    e.get().setDescription(bike.getDescription());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return bike;
            }
        }else{
            return bike;
        }
    }
    public boolean deleteBike(int bikeId){
        Boolean aBoolean=getBike(bikeId).map(bike -> {
            metodosCrud.delete(bike);
            return true;
        }).orElse(false);
        return aBoolean;
    
    }
}


