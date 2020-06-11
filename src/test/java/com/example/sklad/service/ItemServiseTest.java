package com.example.sklad.service;

import com.example.sklad.model.Item;
import com.example.sklad.model.Room;
import com.example.sklad.model.Vendor;
import com.example.sklad.repository.RoomRepository;
import com.example.sklad.repository.VendorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemServiseTest {

    @Autowired
    private ItemServise servise;
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void create() {
        Vendor vendor = vendorRepository.findByNameIgnoreCase("ABB").get();
        Room room = roomRepository.findByNumber(211).get();
        Item item = new Item("cvd03", "1234546", vendor, room);
        item.setQuantity(1);
        servise.create(item);
    }

    @Test
    public void delete() {
        servise.delete(100008);
    }
}