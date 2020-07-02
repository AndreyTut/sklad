package com.example.sklad.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "vendors")
public class Vendor extends AbstractBaseEntity {

    @NotEmpty
    @Size(min = 2, max = 50)
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
