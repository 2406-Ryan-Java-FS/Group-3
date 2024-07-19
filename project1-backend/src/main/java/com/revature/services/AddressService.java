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
    public List<Address> getAddressByUserId(int id){
        return ar.getAddressesByUserId(id);
    }

    public Address addAddress(Address a){
        return ar.save(a);
    }

    public boolean deleteAddress(int id){
        try {
            ar.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

}
