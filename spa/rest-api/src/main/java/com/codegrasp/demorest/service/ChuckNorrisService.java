package com.codegrasp.demorest.service;

import com.codegrasp.demorest.dto.ChuckNorrisFactApiDto;
import com.codegrasp.demorest.repository.FactEntity;
import com.codegrasp.demorest.repository.FactRepository;
import com.codegrasp.demorest.service.model.ChuckFact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
@Slf4j
public class ChuckNorrisService {

    private final int nJokes;
    private RestTemplate restTemplate;
    private FactRepository factRepository;

    public ChuckNorrisService(RestTemplate restTemplate, FactRepository factRepository, @Value("${chuck-api.n-jokes}") int nJokes) {
        this.restTemplate = restTemplate;
        this.factRepository = factRepository;
        this.nJokes = nJokes;
    }

    @Scheduled(fixedRateString = "${chuck-api.fetch-rate-ms}")
    public void retrieveFactFromApi() {
        log.debug("About to fetch Chuck Norris facts");
        for (int i=0; i < this.nJokes ; i++) {
            try {
                ChuckNorrisFactApiDto responseFact = this.restTemplate.getForEntity(URI.create("https://api.chucknorris.io/jokes/random"), ChuckNorrisFactApiDto.class).getBody();
                this.factRepository.save(
                        FactEntity.builder()
                                .value(responseFact.getValue())
                                .id(responseFact.getId())
                                .build()
                );
            } catch(Exception e) {
                log.error("Something happened while trying to get a joke from the API", e);
            }
        }
    }

    public ChuckFact getFact() throws CustomChuckException {
        try {
            List<FactEntity> facts = factRepository.findAll();
            int randomIndex = Double.valueOf(Math.floor(Math.random() * facts.size())).intValue();
            return new ChuckFact(facts.get(randomIndex).getValue());
        } catch(Exception e) {
            log.error("Something happened while trying to get a joke from the API", e);
            throw new CustomChuckException("Something happened while trying to get a joke from the Database");
        }
    }
}
