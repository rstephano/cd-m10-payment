package br.com.iteris.payment.controller;

import br.com.iteris.payment.Paths;
import br.com.iteris.payment.dto.request.PaymentRequest;
import br.com.iteris.payment.dto.response.PaymentResponse;
import br.com.iteris.payment.services.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping(path = Paths.PAYMENT)
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest payment) {
        var paymentProcessed = paymentService.processPayment(payment.getToken(), payment.getValue());
        return ResponseEntity.status(HttpStatus.CREATED) //
            .body( //
                PaymentResponse.builder() //
                    .id(paymentProcessed.getId()) //
                    .token(paymentProcessed.getToken()) //
                    .value(paymentProcessed.getValue()) //
                    .build() //
            );
    }

    @GetMapping(path = Paths.PAYMENT_ID)
    public ResponseEntity<PaymentResponse> getPayment(@PathVariable("id") String id) {
        var payment = paymentService.getPayment(id);
        return ResponseEntity.status(HttpStatus.OK) //
            .body( //
                PaymentResponse.builder() //
                    .id(payment.getId()) //
                    .token(payment.getToken()) //
                    .value(payment.getValue()) //
                    .build() //
            );
    }

}
