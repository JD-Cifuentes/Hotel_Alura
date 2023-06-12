package com.hotel_alura.models.enums;

import javax.swing.*;
import java.lang.reflect.Field;

public enum PaymentMethods {

    CREDIT_CARD("Tarjeta crédito"),
    DEBIT_CARD("Tarjeta débito"),
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

    public static void insertPaymentMethodList(JComboBox jComboBox) throws NoSuchFieldException, IllegalAccessException {

        for (PaymentMethods option : PaymentMethods.values()) {
            Field stringValueField = PaymentMethods.class.getDeclaredField("paymentOption");
            stringValueField.setAccessible(true);

            jComboBox.addItem((String) stringValueField.get(option));

        }
    }


}
