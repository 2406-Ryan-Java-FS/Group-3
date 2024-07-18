package com.revature.controllers;

import com.revature.model.Address;
import com.revature.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    AddressService as;

    @Autowired
    public AddressController(AddressService as){
        this.as = as;
    }

    @GetMapping
    public List<Address> getAllAddresses(){
        return as.getAllAddresses();
    }
}
