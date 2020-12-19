package simulator.projet;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;


@Component
public class ScheduledTasks {

    private class IncidentsFinal { // Will be used once the api is corrected
        private int posX;
        private int posY;
        private String incidentType;
        private int intensity;
    }

    static class MapItem {
        private String id;
        private String posX;
        private String posY;
        private String ground;
    }

    static class Incident {
        private int id;
        MapItem mapItem;
        private String incidentType;
        private int intensity;
    }



    public void decreaseIncidentIntensity(Incident incidentItem){
        incidentItem.intensity -= 1 ;
        RestService.webClient
                .post()
                .uri("/incidents")
                .body(BodyInserters.fromValue("incidentItem"));
    }

    @Scheduled(fixedRate = 5000)
    public void getFromManagerApi() {



        //initialisation of Http request
        RestService.initWebClient();

        //Get list of incidents
        List incidents_list = RestService.getIncidents();
        List trucks_list = RestService.getTrucks();

        for (Object item : incidents_list) {
            Incident incident = (Incident) item;
            int fieldValue = incident.id;

            System.out.println(fieldValue);
        }
        for (Object item : trucks_list) {
            System.out.println(item);
        }









        //url = "http://requestbin.net/r/17p06o01";
        //this.restTemplate.postForObject(url,incidents,String.class);

    }
    @Scheduled(fixedRate = 5000)
    public void generateIncident() {


    }
}
