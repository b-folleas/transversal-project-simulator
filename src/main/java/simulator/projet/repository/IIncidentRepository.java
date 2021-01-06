package simulator.projet.repository;

import simulator.projet.model.Incident;
import simulator.projet.model.IncidentFinal;

import java.util.List;

public interface IIncidentRepository {


    List<Incident> getIncidents();

    Incident createIncident( Incident item );

    Incident decreaseIncidentIntensity(Incident incidentItem) ;


    }
