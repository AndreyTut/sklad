package com.example.sklad.controller;

import com.example.sklad.model.Item;
import com.example.sklad.repository.ItemRepository;
import com.example.sklad.repository.RoomRepository;
import com.example.sklad.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {


    private final RoomRepository roomRepository;
    private final VendorRepository vendorRepository;

    @Autowired
    public IndexController(RoomRepository roomRepository, VendorRepository vendorRepository) {
        this.roomRepository = roomRepository;
        this.vendorRepository = vendorRepository;
    }

    @RequestMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("rooms", roomRepository.findAll());
        model.addAttribute("vendors", vendorRepository.findAll());
        return "index";
    }
}
