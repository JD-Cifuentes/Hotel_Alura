package com.hotel_alura.models.enums;

public enum PaymentMethods {

    CREDIT_CARD("Tarjeta crédito"),
    DEBIT_CARD("Tarjeta debito"),
    CASH("Efectivo");

    private final String paymentOption;

    PaymentMethods(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    @Override
    public String toString() {
        return this.paymentOption;
    }
}
