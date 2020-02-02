package com.codegrasp.demorest.controller;

import com.codegrasp.demorest.dto.ChuckNorrisResponseDto;
import com.codegrasp.demorest.service.ChuckNorrisService;
import com.codegrasp.demorest.service.CustomChuckException;
import com.codegrasp.demorest.service.model.ChuckFact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ChuckNorrisFactController {
    private ChuckNorrisService chuckNorrisService;

    public ChuckNorrisFactController(ChuckNorrisService chuckNorrisService) {
        this.chuckNorrisService = chuckNorrisService;
    }

    @GetMapping("/joke")
    public ResponseEntity<ChuckNorrisResponseDto> getJoke() throws CustomChuckException {
        ChuckFact fact = this.chuckNorrisService.getFact();
        return new ResponseEntity<>(new ChuckNorrisResponseDto(fact.getValue()), HttpStatus.OK);
    }
}
