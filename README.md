# 🚀 consume API

Esse projeto contem exemplo de como consumir uma api e converter o response par json depois para uma lista de objetos.
Utilizando as classes "puras" do java 
```
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
```
Ou a classe RestClient do Spring
```
    private String retrievePeople() {
        var response = restClient.get()
                .uri(uri)
                .retrieve()
                .body(String.class);
        if(Objects.isNull(response) || response.isEmpty())
            return "";
        return response;
    }
```

---

## 📌 Visão Geral

Este projeto implementa uma API que permite ao usuário:

- Listar todas as pessoas
- Listar pessoas filtrando por idade
---

## 🧰 Tecnologias Utilizadas

- Java 21
- Spring Boot 4.0.1
- Spring Web
- Lombok
- Gson
---

## 🧱 Arquitetura — MVC

```
src/main/java/br/ednascimento/consumeapi
├── config
│   └── RestClientConfig
├── controller
│   └── FindPersonController
├── dto
│   ├── DataResponseDto
│   └── PersonDto
└── service
│   ├── ApiConsumerInputStreamService
│   ├── ApiConsumerRestClientService
│   ├── ConverterResponseToPeopleService
│   └── FindPersonService
└── ConsumeApiApplication.java
```

---
## ⚙️ Executando a Aplicação

```bash
./gradlew bootRun
```

Aplicação disponível em `http://localhost:8080`

---

## 🔌 Exemplos de Requisições (cURL)

```bash
curl http://localhost:8080/people | jq
```

```bash
curl http://localhost:8080/people/age/50 | jq
```
---
