package com.hotel_alura.models;

import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("all")
@Entity
@Table(name="reserves")
public class Reserve {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date checkIn;
    private Date checkOut;
    private double price;

    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethod;
    @ManyToOne(optional = false)
    private Guest guests;


    public Reserve() {
    }



    public Guest getGuests() {
        return guests;
    }

    public void setGuests(Guest guests) {
        this.guests = guests;
    }
}
