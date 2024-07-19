package com.revature.controllers;

import com.revature.model.Address;
import com.revature.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public List<Address> getAddressesByUserId(@PathVariable int id){
        return as.getAddressByUserId(id);
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody Address a){
        a = as.addAddress(a);

        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable int id) {
        boolean wasDeleted = as.deleteAddress(id);
        return new ResponseEntity<>(wasDeleted? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
    }
}
