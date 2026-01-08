package br.ednascimento.consumeapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${coderbyte.api.uri-base}")
    private String baseUrlRepository;

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl(baseUrlRepository)
                .build();
    }
}
