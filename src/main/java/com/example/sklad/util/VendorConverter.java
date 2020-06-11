package com.example.sklad.util;

import com.example.sklad.model.Vendor;
import com.example.sklad.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VendorConverter implements Converter<String, Vendor> {

    private final VendorRepository vendorRepository;

    @Autowired
    public VendorConverter(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public Vendor convert(String s) {
        return vendorRepository.findByNameIgnoreCase(s).orElse(new Vendor(s));
    }
}
