package com.revature.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orders", schema = "project1")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;
    private String status;

}
