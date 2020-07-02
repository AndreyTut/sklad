package com.example.sklad.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room extends AbstractBaseEntity {

    @NotNull
    @Size(min=2, max = 4)
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
