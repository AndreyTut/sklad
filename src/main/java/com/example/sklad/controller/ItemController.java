package com.example.sklad.controller;

import com.example.sklad.model.Item;
import com.example.sklad.repository.ItemRepository;
import com.example.sklad.repository.RoomRepository;
import com.example.sklad.repository.VendorRepository;
import com.example.sklad.util.CodeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ItemController {

    private final ItemRepository itemRepository;
    private final VendorRepository vendorRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository, VendorRepository vendorRepository, RoomRepository roomRepository) {
        this.itemRepository = itemRepository;
        this.vendorRepository = vendorRepository;
        this.roomRepository = roomRepository;
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

    @GetMapping("/addexisting/{id}")
    public String adExisting(@PathVariable int id, Model model) {
        Item item = itemRepository.findById(id).get();
        item.setId(null);
        model.addAttribute("item", item);
        model.addAttribute("editing", false);
        return "edit";
    }

    @GetMapping("/additem")
    public String add(Model model) {
        model.addAttribute("editing", false);
        model.addAttribute("vendors", vendorRepository.findAll());
        model.addAttribute("rooms", roomRepository.findAll());
        return "edit";
    }

    @PostMapping("saveitem")
    public String saveEdited(@Valid Item item, Model model) {
        itemRepository.save(item);
        model.addAttribute("items", itemRepository.findByRoomId(item.getRoom().getId()));
        return "items";
    }

    @GetMapping("scanner")
    public String scannerStart() {
        return "scanner";
    }

    @PostMapping("processcode")
    public String scanCode(@RequestParam String code, Model model) {
        String shortCode = CodeResolver.resolve(code);
        List<Item> items = itemRepository.findItemByCode(shortCode);
        if (items.size() > 0) {
            model.addAttribute("items", items);
            return "items";
        }
        Item item = new Item(shortCode.substring(0, 5), shortCode, null, null);
        model.addAttribute("item", item);
        model.addAttribute("editing", false);
        model.addAttribute("vendors", vendorRepository.findAll());
        model.addAttribute("rooms", roomRepository.findAll());
        return "edit";
    }
}
