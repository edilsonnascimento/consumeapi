package br.ednascimento.consumeapi.service;

import br.ednascimento.consumeapi.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindPersonService {

    private final ApiConsumerInputStreamService apiConsumerInputStreamService;
    private final ApiConsumerRestClientService apiConsumerRestClientService;

    public List<PersonDto> findAll() {
        return apiConsumerInputStreamService.findPeople();
    }

    public List<PersonDto> findByAge(Integer age) {
        var people = apiConsumerRestClientService.findPeople();
        return people.stream()
                .filter(person -> person.age().equals(age) || person
                        .age() > age)
                .toList();
    }
}
