package com.example.sklad.repository;

import com.example.sklad.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByVendorId(int vendorId);

    List<Item> findByRoomId(int roomId);

    List<Item> findByVendorIdAndRoomId(int vendorId, int RoomId);

    Optional<Item> findItemByCode(String code);
}
