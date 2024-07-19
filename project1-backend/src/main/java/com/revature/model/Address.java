package com.revature.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "addresses", schema = "project1")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;

    private String address;

    private int userId;
}
