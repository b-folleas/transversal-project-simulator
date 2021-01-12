package simulator.projet.service;

import org.springframework.stereotype.Service;
import simulator.projet.model.Incident;
import simulator.projet.model.IncidentToIncreaseModel;
import simulator.projet.repository.Irepository.IIncidentRepository;
import simulator.projet.service.Iservice.IIncidentToIncrease;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentToIncrease implements IIncidentToIncrease {

    private final List<IncidentToIncreaseModel> incidentToIncreaseModelList;
    private final IIncidentRepository incidentRepository;

    public IncidentToIncrease(IIncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
        this.incidentToIncreaseModelList = new ArrayList<>();
    }

    @Override
    public List<IncidentToIncreaseModel> needToIncrease() {
        List<Incident> incidents = this.incidentRepository.getIncidents();

        List<IncidentToIncreaseModel> incidentList = new ArrayList<>();
        Optional<IncidentToIncreaseModel> incidentToIncreaseModelOptional;
        IncidentToIncreaseModel incidentToIncreaseModel;

        for (Incident incident : incidents) {
            incidentToIncreaseModelOptional = this.incidentToIncreaseModelList.stream().filter(itim -> itim.getIdIncident().equals(incident.getId())).findFirst();

            if (incidentToIncreaseModelOptional.isPresent()) {
                incidentToIncreaseModel = incidentToIncreaseModelOptional.get();

                // Si jamais l'incident n'a toujours pas changé d'intensité alors on rajoute un coup d'horloge.
                if (incidentToIncreaseModel.getIntensity() == incident.getIntensity()) {
                    incidentToIncreaseModel.incrementNext();
                } else {
                    // Sinon on le remet à 0
                    incidentToIncreaseModel.setNbHorloge(0);
                    incidentToIncreaseModel.setIntensity(incident.getIntensity());
                }

                // Si jamais le coup d'horloge est égal à 10 alors on augmente l'intensité.
                if (incidentToIncreaseModel.getNbHorloge() == 10) {
                    if (incidentToIncreaseModel.incrementIntencity()) {
                        incidentList.add(incidentToIncreaseModel);
                    }
                }
            } else {
                this.incidentToIncreaseModelList.add(new IncidentToIncreaseModel(incident.getId(), incident.getIntensity()));
            }
        }

        this.incidentToIncreaseModelList.removeIf(itim -> incidents.stream().noneMatch(i -> i.getId().equals(itim.getIdIncident())));

        return incidentList;
    }
}
