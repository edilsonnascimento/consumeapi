package br.ednascimento.consumeapi.service;

import br.ednascimento.consumeapi.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class ApiConsumerRestClientService {

    @Value("${coderbyte.api.age-counting-uri}")
    private String uri;

    private final RestClient restClient;
    private final ConverterResponseToPeopleService converterResponseService;

    public List<PersonDto> findPeople() {
        var response = retrievePeople();
        return converterResponseService.convert(response);
    }

    private String retrievePeople() {
        var response = restClient.get()
                .uri(uri)
                .retrieve()
                .body(String.class);
        if(Objects.isNull(response) || response.isEmpty())
            return "";
        return response;
    }
}
