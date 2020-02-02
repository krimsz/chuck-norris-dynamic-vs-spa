package com.codegrasp.demorest.controller;

import com.codegrasp.demorest.dto.ChuckNorrisResponseDto;
import com.codegrasp.demorest.service.ChuckNorrisService;
import com.codegrasp.demorest.service.CustomChuckException;
import com.codegrasp.demorest.service.model.ChuckFact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class ChuckNorrisFactController {
    private ChuckNorrisService chuckNorrisService;

    public ChuckNorrisFactController(ChuckNorrisService chuckNorrisService) {
        this.chuckNorrisService = chuckNorrisService;
    }

    @RequestMapping("/joke")
    public String getJoke(Map<String, Object> model) throws CustomChuckException {
        ChuckFact fact = this.chuckNorrisService.getFact();
        model.put("fact", fact.getValue());
        return "fact";
    }
}
