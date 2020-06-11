package com.example.sklad.repository;

import com.example.sklad.model.Vendor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VendorRepositoryTest {

    @Autowired
    private VendorRepository repository;

    @Test
    public void save(){
    repository.save(new Vendor("ABB updated"));
    }
}