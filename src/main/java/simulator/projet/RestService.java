package simulator.projet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;


@Service
public class RestService {

    @Value("${api.baseUrl}") static String baseUrl;


    public static WebClient webClient ;


    public static void initWebClient() {

        webClient = WebClient.builder()
                .baseUrl("http://localhost:8080")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();;
    }

    public static List getIncidents(){
        return(webClient
                .get()
                .uri("/incidents")
                .retrieve()
                .bodyToMono(List.class)
                .block());
    }

    public static List getTrucks(){
        return(webClient
                .get()
                .uri("/trucks")
                .retrieve()
                .bodyToMono(List.class)
                .block());
    }

}