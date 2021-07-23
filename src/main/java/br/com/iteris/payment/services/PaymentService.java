package br.com.iteris.payment.services;

import br.com.iteris.payment.dto.Card;
import br.com.iteris.payment.dto.Payment;
import br.com.iteris.payment.exceptions.InvalidCardException;
import br.com.iteris.payment.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentService {

    private final Map<String, Card> cardTokensDb;

    private Map<String, Payment> paymentDb = new HashMap<>();

    public Payment processPayment(String token, BigDecimal value) {
        log.info("Checking card with token {}", token);
        var card = Optional.ofNullable(cardTokensDb.get(token)) //
            .orElseThrow(InvalidCardException::new);
        var id = UUID.randomUUID().toString();
        var payment = Payment.builder() //
            .id(id) //
            .token(token) //
            .value(value) //
            .build();
        paymentDb.put(id, payment);
        log.info("Card found. {}", card.toString());
        log.info("Payment processed. Id: {}", id);
        return payment;
    }

    public Payment getPayment(String id) {
        log.info("Getting payment with id {}", id);
        return Optional.ofNullable(paymentDb.get(id)) //
            .orElseThrow(NotFoundException::new);
    }

}
