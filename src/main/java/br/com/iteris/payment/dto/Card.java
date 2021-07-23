package br.com.iteris.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {

    private String token;

    private String name;

    private LocalDate expiration;

    private Long number;

    private Long cvv;

}
