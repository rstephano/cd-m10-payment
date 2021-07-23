package br.com.iteris.payment;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Paths {

    public static final String PAYMENT = "/payment";

    public static final String PAYMENT_ID = PAYMENT + "/{id}";

}
