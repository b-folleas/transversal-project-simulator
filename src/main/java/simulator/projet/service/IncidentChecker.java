package simulator.projet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import simulator.projet.model.Incident;
import simulator.projet.model.IncidentType;
import simulator.projet.model.MapItem;
import simulator.projet.model.viewModel.IncidentViewModel;
import simulator.projet.repository.Irepository.IIncidentRepository;
import simulator.projet.repository.Irepository.IMapRepository;
import simulator.projet.service.Iservice.IIncidentChecker;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidentChecker implements IIncidentChecker {

    private static final Logger logger = LoggerFactory.getLogger(IncidentChecker.class);
    private final RandomService randomService;
    private final IIncidentRepository incidentRepository;
    private final IMapRepository mapRepository;
    @Value("${incidentRate}")
    private int incidentRate;
    private List<Incident> incidentList;
    private List<MapItem> mapItemsList;

    public IncidentChecker(IIncidentRepository incidentRepository, IMapRepository mapRepository, RandomService randomService) {
        this.incidentRepository = incidentRepository;
        this.mapRepository = mapRepository;
        this.randomService = randomService;
    }

    /**
     * Renvoie une liste incidentViewModel qui vont être créé par la suite
     *
     * @return
     */
    public List<IncidentViewModel> incidentsToGenerate() {
        incidentList = incidentRepository.getIncidents();
        mapItemsList = mapRepository.getMapItems();

        List<IncidentViewModel> resultList = new ArrayList<>();

        // Ajoute un nouvel incident a une position donnee si il n y en a pas
        for (int i = 0; i < incidentRate; i++) {
            logger.info("Building incident");

            MapItem mapItem = mapItemsList.get(randomService.randIndex(mapItemsList));
            boolean alreadyExist = incidentList.stream().anyMatch(m -> m.getMapItem().getPosX().equals(mapItem.getPosX()) || m.getMapItem().getPosY().equals(mapItem.getPosY()));
            if (!alreadyExist) {

                IncidentViewModel incident = new IncidentViewModel();
                incident.setPosX(mapItem.getPosX());
                incident.setPosY(mapItem.getPosY());
                incident.setIntensity(randomService.randInt(10));

                switch (mapItem.getGround()) {
                    case GARDEN:
                        incident.setIncidentType(IncidentType.TORNADO);
                        break;
                    case BUILDING:
                        incident.setIncidentType(IncidentType.FIRE);
                        break;
                    case ROAD:
                        incident.setIncidentType(IncidentType.ACCIDENT);
                        break;
                    case WATER:
                        incident.setIncidentType(IncidentType.FLOOD);
                        break;
                    default:
                        break;
                }
                logger.info("Incident  : " + incident.toString() + " builded");

                resultList.add(incident);
            }
        }

        return resultList;


    }
}

