package com.hotel_alura.models;

import com.hotel_alura.models.enums.PaymentMethods;

import javax.persistence.*;
import java.time.Clock;
import java.time.LocalDate;

@SuppressWarnings("all")
@Entity
@Table(name="reserves")
public class Reserve {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private LocalDate registerDate;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double price;

    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethod;
    @ManyToOne(optional = false)
    @JoinColumn(name = "guest_id")
    private Guest guest;


    public Reserve() {
    }

    public Reserve(LocalDate checkIn, LocalDate checkOut, double price, PaymentMethods paymentMethod) {
        this.registerDate = LocalDate.now(Clock.systemUTC());
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = price;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return this.registerDate.toString();
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public void setPrice() {
        this.price = price;
    }

    public void setPaymentMethod(PaymentMethods paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void setPaymentMethod(String paymentOption) throws NoSuchFieldException, IllegalAccessException{
        this.paymentMethod = PaymentMethods.getPaymentMethodByPaymentOption(paymentOption);
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public double getPrice() {
        return price;
    }

    public PaymentMethods getPaymentMethod() {
        return paymentMethod;
    }

    public Guest getGuest() {
        return guest;
    }
}
