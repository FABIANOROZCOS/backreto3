package com.bike.repository;

import com.bike.model.Client;
import com.bike.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository crud1;
    
    public List<Client> getAll(){
        return (List<Client>) crud1.findAll();
    }
    public Optional<Client> getClient(int id){
        return crud1.findById(id);
    }

    public Client save(Client client){
        return crud1.save(client);
    }
    
    public void delete(Client client){
        crud1.delete(client);
    }
}

