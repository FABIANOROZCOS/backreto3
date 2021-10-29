package com.bike.repository;

import com.bike.model.Reservation;
import com.bike.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository crud4;

    public List<Reservation> getAll(){
        return (List<Reservation>) crud4.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return crud4.findById(id);
    }
    
    public Reservation save (Reservation reservation) {
        return crud4.save(reservation);
    }
    
    public void delete(Reservation reservation){
        crud4.delete(reservation);
    }
}
