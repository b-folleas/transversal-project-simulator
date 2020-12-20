package simulator.projet.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import simulator.projet.model.Incident;

@Component
public class IncidentRepository extends BaseRepository<Incident> {

    public IncidentRepository(@Value("${api.baseUrl}") String baseUrl) {
        super(baseUrl);
    }

    @Override
    Class<Incident> getClassObject() {
        return Incident.class;
    }
}
