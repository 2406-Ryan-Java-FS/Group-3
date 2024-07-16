package com.revature.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "categories", schema = "project1")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
