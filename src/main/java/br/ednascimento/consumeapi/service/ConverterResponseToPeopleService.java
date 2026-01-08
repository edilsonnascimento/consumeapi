package br.ednascimento.consumeapi.service;

import br.ednascimento.consumeapi.dto.PersonDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConverterResponseToPeopleService {

    public List<PersonDto> convert(String response) {
        var json = convertToJson(response);
        return mapToPeople(json);
    }
    private String convertToJson(String response) {
        var rawData = response
                .replace("{\"data\":\"", "")
                .replace("\"}", "");
        var formatFields = rawData
                .replace("key=", "{\"key\":\"")
                .replace(", age=", "\",\"age\":");
        var formatItems = formatFields.replace(", {", "},\n  {");
        return "[\n  " + formatItems + "}\n]";
    }

    private List<PersonDto> mapToPeople(String json) {
        var gson = new Gson();
        var peopleType = new TypeToken<List<PersonDto>>() {}.getType();
        return gson.fromJson(json, peopleType);
    }
}
