package com.example.sklad.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room extends AbstractBaseEntity {

    @NotNull
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
