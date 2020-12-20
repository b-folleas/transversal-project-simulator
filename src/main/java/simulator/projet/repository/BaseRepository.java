package simulator.projet.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public abstract class BaseRepository<T> {

    private final Logger logger = LoggerFactory.getLogger(BaseRepository.class);

    private final WebClient webClient;

    /**
     * Initialize the webclient for the API
     *
     * @param baseUrl url to find the api location
     */
    public BaseRepository(String baseUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    /**
     * Return a list of T object instance from the url
     *
     * @param url url to find the resource
     * @return a list of T instance
     */
    public List<T> getList(String url) {
        logger.info("HTTP Get for list at the url : " + url);
        return this.webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToFlux(this.getClassObject())
                .collectList()
                .block();
    }

    /**
     * Get a item from the url
     *
     * @param url url to find the resource
     * @return this T object instance
     */
    public T getItem(String url) {
        logger.info("HTTP Get for item at the url : " + url);
        return this.webClient
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(this.getClassObject())
                .block();
    }

    /**
     * Get the Class lt;Tgt; object
     *
     * @return Class lt;Tgt; object
     */
    abstract Class<T> getClassObject();
}
