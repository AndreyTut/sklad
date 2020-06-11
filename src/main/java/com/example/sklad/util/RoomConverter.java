package com.example.sklad.util;

import com.example.sklad.model.Room;
import com.example.sklad.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoomConverter implements Converter<String, Room> {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomConverter(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room convert(String s) {
        int number = Integer.parseInt(s);
        return roomRepository.findByNumber(number).orElse(new Room(number));
    }
}
