package com.example.sklad.service;

import com.example.sklad.model.Item;
import com.example.sklad.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServise {

    private final ItemRepository repository;

    @Autowired
    public ItemServise(ItemRepository repository) {
        this.repository = repository;
    }

    public void create(Item item){
        repository.save(item);
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}
