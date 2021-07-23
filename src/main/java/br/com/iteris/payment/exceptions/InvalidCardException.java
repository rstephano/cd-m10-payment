package br.com.iteris.payment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PAYMENT_REQUIRED, reason = "Invalid card")
public class InvalidCardException extends RuntimeException {
}
