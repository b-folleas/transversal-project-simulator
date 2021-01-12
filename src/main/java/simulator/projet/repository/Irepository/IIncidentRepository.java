package simulator.projet.repository.Irepository;

import simulator.projet.model.Incident;
import simulator.projet.model.viewModel.IncidentViewModel;

import java.util.List;

public interface IIncidentRepository {


    List<Incident> getIncidents();

    Incident createIncident(IncidentViewModel item);

    Incident updateIncidentIntensity(Long incident_id, int new_intensity);

}
