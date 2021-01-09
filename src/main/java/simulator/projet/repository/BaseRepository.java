package simulator.projet.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

public abstract class BaseRepository<T> {

    private final Logger logger = LoggerFactory.getLogger(BaseRepository.class);

    private final WebClient webClient;
    private final String baseUrlManager;
    private WebClient WebClientManager;


    /**
     * Initialize the webclient for the API
     *
     * @param baseUrl url to find the api location
     */
    public BaseRepository(String baseUrl, String baseUrlManager) {
        this.baseUrlManager = baseUrlManager;
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }


    public List<T> getList(String url) {
        return getList(url, false);
    }

    /**
     * Return a list of T object instance from the url
     *
     * @param url url to find the resource
     * @return a list of T instance
     */
    public List<T> getList(String url, boolean isManagerApi) {
        logger.info("HTTP Get for list at the url : " + url);

        return (isManagerApi ? this.getWebClientManager() : this.webClient)
                .get()
                .uri(url)
                .retrieve()
                .bodyToFlux(this.getClassObject())
                .collectList()
                .block();
    }

    private WebClient getWebClientManager() {
        if (WebClientManager == null) {
            this.WebClientManager = WebClient.builder()
                    .baseUrl(baseUrlManager)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .build();
        }
        return this.WebClientManager;
    }


    public T getItem(String url) {
        return getItem(url, false);
    }

    /**
     * Get a item from the url
     *
     * @param url url to find the resource
     * @return this T object instance
     */
    public T getItem(String url, boolean isManagerApi) {
        logger.info("HTTP Get for item at the url : " + url);
        return (isManagerApi ? this.getWebClientManager() : this.webClient)
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(this.getClassObject())
                .block();
    }


    public T postItem(String url, Object item, Class<?> classItem) {
        return postItem(url, item, classItem, false);
    }

    public T postItem(String url, Object item, Class<?> classItem, boolean isManagerApi) {
        logger.info("Posting item at url : " + url);
        return (isManagerApi ? this.getWebClientManager() : this.webClient)
                .post()
                .uri(url)
                .body(Mono.just(item), classItem)
                .retrieve()
                .bodyToMono(this.getClassObject())
                .block();
    }

    public T putItem(String url, Object item, Class<?> classItem) {
        return postItem(url, item, classItem, false);
    }

    public T putItem(String url, Object item, Class<?> classItem, boolean isManagerApi) {
        logger.info("Putting item at url : " + url);
        return (isManagerApi ? this.getWebClientManager() : this.webClient)
                .put()
                .uri(url)
                .body(Mono.just(item), classItem)
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
