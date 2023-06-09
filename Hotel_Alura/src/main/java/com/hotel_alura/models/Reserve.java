package com.hotel_alura.models;

import com.hotel_alura.models.enums.PaymentMethods;

import javax.persistence.*;
import java.time.Clock;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

    private static final double standarRoomValue = 20000;

    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethod;
    @ManyToOne(optional = false)
    @JoinColumn(name = "guest_id")
    private Guest guest;


    public Reserve() {
    }

    public Reserve(LocalDate checkIn, LocalDate checkOut, String paymentMethod) throws NoSuchFieldException, IllegalAccessException {
        this.registerDate = LocalDate.now(Clock.systemUTC());
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        setPrice();
        setPaymentMethod(paymentMethod);
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
        this.price = ChronoUnit.DAYS.between(checkIn, checkOut)*standarRoomValue;
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

    public static double getStandarRoomValue() {
        return standarRoomValue;
    }
}
