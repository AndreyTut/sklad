package com.example.sklad.controller;

import com.example.sklad.repository.RoomRepository;
import com.example.sklad.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
