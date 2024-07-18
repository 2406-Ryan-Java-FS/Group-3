package com.revature.services;

import com.revature.model.Address;
import com.revature.repositories.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    AddressRepo ar;

    @Autowired
    public AddressService(AddressRepo ar){
        this.ar = ar;
    }

    public List<Address> getAllAddresses(){
        return ar.findAll();
    }
    public Address getAddressByID(int id){
        return ar.getReferenceById(id);
    }

}
