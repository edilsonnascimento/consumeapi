package br.ednascimento.consumeapi.service;

import br.ednascimento.consumeapi.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class ApiConsumerInputStreamService {

    @Value("${coderbyte.api.uri-base}")
    private String baseUrlRepository;
    @Value("${coderbyte.api.age-counting-uri}")
    private String uri;

    private final ConverterResponseToPeopleService converterResponseToPeopleService;

    public List<PersonDto> findPeople() {
        var response = retrieveData();
        return converterResponseToPeopleService.convert(response);
    }

    private String retrieveData() {
        try (var inputStream = new URI(baseUrlRepository + uri).toURL()
                .openConnection()
                .getInputStream()) {
            return new String(inputStream.readAllBytes());
        } catch (Exception e) {
            log.warn("Error retrieveData API {} ", e.getMessage());
        }
        return "";
    }
}
