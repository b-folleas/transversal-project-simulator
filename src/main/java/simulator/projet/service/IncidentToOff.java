package simulator.projet.service;

import org.springframework.stereotype.Service;
import simulator.projet.model.Incident;
import simulator.projet.model.Truck;
import simulator.projet.repository.Irepository.IIncidentRepository;
import simulator.projet.repository.Irepository.ITruckRepository;
import simulator.projet.service.Iservice.IIncidentToOff;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentToOff implements IIncidentToOff {

    private final IIncidentRepository incidentRepository;
    private final ITruckRepository truckRepository;

    public IncidentToOff(IIncidentRepository incidentRepository, ITruckRepository truckRepository) {
        this.incidentRepository = incidentRepository;
        this.truckRepository = truckRepository;
    }

    public List<Incident> fetchIncidentsToOff() {
        List<Incident> incidents_list = incidentRepository.getIncidents();
        List<Truck> trucks_list = truckRepository.getTrucks();

        List<Incident> incidentsToDecreaseIntensity_list = new ArrayList<>();

        for (Truck truckItem : trucks_list) {
            Optional<Incident> matchingIncident = incidents_list.stream().filter(m -> m.getMapItem().getId().equals(truckItem.getMapItem().getId())).findFirst();
            matchingIncident.ifPresent(incidentsToDecreaseIntensity_list::add);
        }

        return incidentsToDecreaseIntensity_list;

    }

}
