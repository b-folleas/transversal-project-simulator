package simulator.projet.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import simulator.projet.model.Incident;
import simulator.projet.model.viewModel.IncidentViewModel;
import simulator.projet.repository.Irepository.IIncidentRepository;

import java.util.List;

@Service
public class IncidentRepository extends BaseRepository<Incident> implements IIncidentRepository {

    public IncidentRepository(@Value("${api.baseUrl}") String baseUrl, @Value("${api.baseUrlManager}") String baseUrlManager) {
        super(baseUrl, baseUrlManager);
    }

    @Override
    public List<Incident> getIncidents() {
        return this.getList("/incidents");
    }

    @Override
    public Incident createIncident(IncidentViewModel incidentItem) {
        return this.postItem("/incident", incidentItem, IncidentViewModel.class);
    }

    @Override
    public Incident updateIncidentIntensity(Incident incident, int newIntensity) {
        return this.postItem("/incident/" + incident.getId() + "/intensity/" + newIntensity, "", IncidentViewModel.class);
    }

    @Override
    Class<Incident> getClassObject() {
        return Incident.class;
    }
}
