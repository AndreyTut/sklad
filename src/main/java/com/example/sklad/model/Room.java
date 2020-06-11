package com.example.sklad.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room extends AbstractBaseEntity {

    private Integer number;

    @OneToMany(mappedBy = "room")
    private List<Item> items;

    public Room(Integer number) {
        this.number = number;
    }

    public Room() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
