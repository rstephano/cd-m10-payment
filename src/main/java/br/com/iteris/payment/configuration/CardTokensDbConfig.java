package br.com.iteris.payment.configuration;

import br.com.iteris.payment.dto.Card;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Configuration
public class CardTokensDbConfig {

    private final Faker faker;

    @Bean
    public Map<String, Card> cardTokensDb() {
        return Stream.of( //
            "afe62777-4dec-4981-807b-12c77ffe14d9", //
            "7596cbc7-1fca-4e08-8dcc-3559e5606ce4", //
            "a4e005a2-af8d-4436-ada8-a9366661b272", //
            "cecba782-86a3-47e4-9592-32956a32232b", //
            "48a22d70-fb8e-4ac4-bac6-aa63d5841686", //
            "35717d05-6560-4f59-9c01-484fca5bcd89", //
            "7d7290c1-11ec-4163-a684-b2f9ceddcce1", //
            "2ddd0e78-e1e5-457d-9db1-db81c2da749d", //
            "5e0d1b57-5aba-4e22-9037-63bb9650ce49", //
            "5cf2b679-dcd1-4ae9-bdf6-b9a26df88e40") //
            .map(x -> Card.builder() //
                .token(x) //
                .name(faker.lordOfTheRings().character()) //
                .expiration(LocalDate.now().withDayOfMonth(1).plusYears(5)) //
                .number(Long.valueOf(faker.number().digits(16))) //
                .cvv(Long.valueOf(faker.number().digits(3))) //
                .build() //
            ) //
            .collect(Collectors.toMap(Card::getToken, Function.identity()));
    }

}
