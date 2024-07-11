package com.revature.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private Long id;

    private int user_id;

    private String status;

    private Date create_at;

    public Order(){

    }

    public Order(Long id, int user_id, String status, Date create_at){
        this.id = id;
        this.user_id = user_id;
        this.status = status;
        this.create_at = create_at;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", status='" + status + '\'' +
                ", create_at=" + create_at +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return user_id == order.user_id && Objects.equals(id, order.id) && Objects.equals(status, order.status) && Objects.equals(create_at, order.create_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, status, create_at);
    }
}
