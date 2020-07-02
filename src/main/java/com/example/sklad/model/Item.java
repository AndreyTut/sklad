package com.example.sklad.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item extends AbstractBaseEntity {

    @NotNull
    private String name;

    private String code;

    @NotNull
    private Integer quantity;

    @NotNull
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Vendor vendor;

    @NotNull
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Room room;

    public Item() {
    }

    public Item(String name, String code, Vendor vendor, Room room) {
        this.name = name;
        this.code = code;
        this.vendor = vendor;
        this.room = room;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", quantity=" + quantity +
                ", vendor=" + vendor +
                ", room=" + room +
                '}';
    }
}
