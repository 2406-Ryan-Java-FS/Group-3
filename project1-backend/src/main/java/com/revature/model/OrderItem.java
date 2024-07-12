package com.revature.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "order_item", schema = "project1")
@Data
public class OrderItem {

    @Id
    private int id;
}
