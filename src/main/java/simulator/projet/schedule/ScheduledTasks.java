package simulator.projet.schedule;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import simulator.projet.model.*;
import simulator.projet.repository.IBarrackRepository;
import simulator.projet.repository.IIncidentRepository;
import simulator.projet.repository.IMapRepository;
import simulator.projet.repository.ITruckRepository;
import simulator.projet.service.RandomService;
import simulator.projet.service.RestService;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ScheduledTasks {

    private final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    //private final RestService restService;

    private final IIncidentRepository incidentRepository;
    private final ITruckRepository truckRepository;
    private final IBarrackRepository barrackRepository;
    private final IMapRepository mapRepository;

    private List<Truck> trucklist;
    private List<Incident> incidentList;
    private List<Barrack> barrackList ;
    private List<MapItem> mapItemsList ;

    public ScheduledTasks(RestService restService, IIncidentRepository incidentRepository, ITruckRepository truckRepository, IMapRepository mapRepository, IBarrackRepository barrackRepository) {
        //this.restService = restService;
        this.incidentRepository = incidentRepository;
        this.truckRepository = truckRepository;
        this.barrackRepository = barrackRepository;
        this.mapRepository = mapRepository;
    }


    public void init() {

        barrackList = this.barrackRepository.getBarracks();
        mapItemsList = this.mapRepository.getMapItems();

        for (Barrack barrack : barrackList) {
            logger.info("Barrack info : " + barrack.toString());
        }

        for (MapItem mapItem : mapItemsList) {
            logger.info("Barrack info : " + mapItem.toString());
        }
    }


    @Scheduled(fixedRate = 5000)
    public void run() {

        trucklist = this.truckRepository.getTrucks() ;
        incidentList = this.incidentRepository.getIncidents() ;

        for (Incident incident : incidentList) {
            logger.info("Incident info : " + incident.toString());
            //logger.info("Incident info from API : " + this.incidentRepository.getItem("/incident/" + incident.getId()));
        }

        for (Truck truck : trucklist) {
            logger.info("Truck info : " + truck.toString());
            logger.info("Truck info from API : " + this.truckRepository.getTruck(truck.getId()));
        }

    }




//    public void moveTruck()

    public void generateIncident() {
        List<MapItem> buildings = this.mapRepository.getMapItems().stream().filter(m -> m.getGround() == Ground.BUILDING ).collect(Collectors.toList());

        // TODO verifier si il y a feu
        Incident incident = new Incident();


        incident.setMapItem( buildings.get(new RandomService().randInt(buildings.size())) );
        incident.setIntensity(new RandomService().randInt(10));
        incident.setIncidentType(IncidentType.FIRE);


        Incident createdIncident = this.incidentRepository.createIncident(incident);
        logger.info("Created incident  : " + incident.toString());

    }
}
