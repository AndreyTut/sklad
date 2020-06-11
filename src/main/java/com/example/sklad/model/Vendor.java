package com.example.sklad.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vendors")
public class Vendor extends AbstractBaseEntity {

    private String name;

    @OneToMany(mappedBy = "vendor")
    private List<Item> items;

    public Vendor() {
    }

    public Vendor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}
