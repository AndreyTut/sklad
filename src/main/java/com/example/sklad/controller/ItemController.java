package com.example.sklad.controller;

import com.example.sklad.model.Item;
import com.example.sklad.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ItemController {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/getbyroom/{id}")
    public String getByRoom(@PathVariable int id, Model model) {
        model.addAttribute("items", itemRepository.findByRoomId(id));
        return "items";
    }

    @GetMapping("/getbyvendor/{id}")
    public String getByVendor(@PathVariable int id, Model model) {
        model.addAttribute("items", itemRepository.findByVendorId(id));
        return "items";
    }


    @GetMapping("/edititem/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("item", itemRepository.findById(id).get());
        model.addAttribute("editing", true);
        return "edit";
    }

    @GetMapping("/additem")
    public String add(Model model){
        model.addAttribute("editing", false);
        return "edit";
    }

    @PostMapping("saveitem")
    public String saveEdited(Item item, Model model) {
        itemRepository.save(item);
        model.addAttribute("items", itemRepository.findByRoomId(item.getRoom().getId()));
        return "items";
    }
}
