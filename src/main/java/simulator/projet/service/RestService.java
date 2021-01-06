package simulator.projet.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import simulator.projet.model.Incident;
import simulator.projet.model.Truck;

import java.util.List;


@Service
public class RestService {

    private final WebClient webClient;

    private final String baseUrl;

    public RestService(@Value("${api.baseUrl}") String baseUrl) {
        this.baseUrl = baseUrl;
        // Initialize the webClient
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }



    public List<Incident> getIncidents() {
        return this.webClient
                .get()
                .uri("/incidents")
                .retrieve()
                .bodyToFlux(Incident.class)
                .collectList()
                .block();
    }

    public List<Truck> getTrucks() {
        return this.webClient
                .get()
                .uri("/trucks")
                .retrieve()
                .bodyToFlux(Truck.class)
                .collectList()
                .block();
    }

    public void decreaseIncidentIntensity(Incident incident) {
        this.webClient
                .post()
                .uri("/incidents")
                .body(BodyInserters.fromValue("incident"));
    }

}
