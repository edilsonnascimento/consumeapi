package br.ednascimento.consumeapi.controller;

import br.ednascimento.consumeapi.dto.PersonDto;
import br.ednascimento.consumeapi.service.ApiConsumerInputStreamService;
import br.ednascimento.consumeapi.service.FindPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/people")
@RestController
public class FindPersonController {

    private final FindPersonService service;

    @GetMapping
    public List<PersonDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/age/{age}")
    public List<PersonDto> findByAge(@PathVariable Integer age) {
        return service.findByAge(age);
    }
}
