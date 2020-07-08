package com.example.sklad.repository;

import com.example.sklad.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByVendorIdOrderByName(int vendorId);

    List<Item> findByRoomIdOrderByName(int roomId);

    List<Item> findByVendorIdAndRoomId(int vendorId, int RoomId);

    List<Item> findItemByCodeOrderByName(String code);
}
