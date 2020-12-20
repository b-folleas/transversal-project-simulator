package simulator.projet.schedule;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import simulator.projet.model.Incident;
import simulator.projet.model.Truck;
import simulator.projet.repository.ITruckRepository;
import simulator.projet.repository.IncidentRepository;
import simulator.projet.service.RestService;

import java.util.List;


@Component
public class ScheduledTasks {

    private final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private final RestService restService;

    private final IncidentRepository incidentRepository;
    private final ITruckRepository truckRepository;

    public ScheduledTasks(RestService restService, IncidentRepository incidentRepository, ITruckRepository truckRepository) {
        this.restService = restService;
        this.incidentRepository = incidentRepository;
        this.truckRepository = truckRepository;
    }

    public void decreaseIncidentIntensity(Incident incidentItem) {
        incidentItem.setIntensity(incidentItem.getIntensity() - 1);
        this.restService.decreaseIncidentIntensity(incidentItem);
    }

    @Scheduled(fixedRate = 5000)
    public void getFromManagerApi() {

        //Get list of incidents
        List<Incident> incidents = this.incidentRepository.getList("/incidents");
        List<Truck> truckList = this.truckRepository.getTrucks();

        for (Incident incident : incidents) {
            logger.info("Incident info : " + incident.toString());
            logger.info("Incident info from API : " + this.incidentRepository.getItem("/incident/" + incident.getId()));
        }

        for (Truck truck : truckList) {
            logger.info("Truck info : " + truck.toString());
            logger.info("Truck info from API : " + this.truckRepository.getTruck(truck.getId()));
        }
    }


    @Scheduled(fixedRate = 5000)
    public void generateIncident() {


    }
}
