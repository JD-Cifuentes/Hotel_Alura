package com.hotel_alura.models.enums;

import java.lang.reflect.Field;

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

    public static PaymentMethods getPaymentMethodByPaymentOption(String paymentOption) throws NoSuchFieldException, IllegalAccessException {

        for (PaymentMethods option : PaymentMethods.values()) {
            Field stringValueField = PaymentMethods.class.getDeclaredField("paymentOption");
            stringValueField.setAccessible(true);

            String enumStringValue = (String) stringValueField.get(option);

            if (paymentOption.equals(enumStringValue)) {
                return option;
            }
        }

        throw new NoSuchFieldException();
    }



}
