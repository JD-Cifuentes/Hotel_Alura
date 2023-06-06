package com.hotel_alura.models;

import javax.persistence.*;

@Entity
@Table(name="hotel_user")
public class HotelUser {
    @Id
    @Column(unique = true)
    private String login;
    @Column(unique = true)
    private String pass;



}
