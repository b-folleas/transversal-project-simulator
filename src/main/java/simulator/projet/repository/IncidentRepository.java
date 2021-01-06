package simulator.projet.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import simulator.projet.model.Incident;

import java.util.List;

@Component
public class IncidentRepository extends BaseRepository<Incident> implements IIncidentRepository {

    public IncidentRepository(@Value("${api.baseUrl}") String baseUrl, @Value("${api.baseUrlManager}") String baseUrlManager) {
        super(baseUrl,baseUrlManager);
    }

    @Override
    public List<Incident> getIncidents(){ return this.getList("/incidents");
    }

    @Override
    public Incident createIncident( Incident Item){
        return this.postItem("/incident", Item );
    }

    @Override
    public Incident decreaseIncidentIntensity(Incident incidentItem) {
        incidentItem.setIntensity(incidentItem.getIntensity() - 1);
        return this.postItem("/incident" , incidentItem);
    }

    @Override
    Class<Incident> getClassObject() {
        return Incident.class;
    }
}
