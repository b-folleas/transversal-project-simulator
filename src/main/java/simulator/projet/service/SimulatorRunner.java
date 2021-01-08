package simulator.projet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import simulator.projet.model.Incident;
import simulator.projet.model.Truck;
import simulator.projet.model.viewModel.IncidentViewModel;
import simulator.projet.repository.Irepository.IIncidentRepository;
import simulator.projet.repository.Irepository.ITruckRepository;
import simulator.projet.service.Iservice.IIncidentChecker;
import simulator.projet.service.Iservice.ISimulatorRunner;
import simulator.projet.service.Iservice.ITruckToMove;

import java.util.List;

@Service
public class SimulatorRunner implements ISimulatorRunner {

    private static final Logger logger = LoggerFactory.getLogger(simulator.projet.Main.class);
    private final IIncidentChecker incidentChecker;
    private final IIncidentRepository incidentRepository;
    private final IncidentToOff incidentToOff;
    private final ITruckToMove truckToMove;
    private final ITruckRepository truckRepository;

    @Value("${clockRate}")
    private int clockRate;

    public SimulatorRunner(IIncidentChecker incidentChecker,
                           IIncidentRepository incidentRepository,
                           IncidentToOff incidentToOff,
                           ITruckToMove truckToMove,
                           ITruckRepository truckRepository) {
        this.incidentChecker = incidentChecker;
        this.incidentRepository = incidentRepository;
        this.incidentToOff = incidentToOff;
        this.truckToMove = truckToMove;
        this.truckRepository = truckRepository;
    }

    public void runner() throws InterruptedException {

        logger.info("Starting runner...");
        while (true) {
            //Generation incidents
            List<IncidentViewModel> incidentToCreate_list = this.incidentChecker.incidentsToGenerate();
            for (IncidentViewModel incidentVM : incidentToCreate_list) {
                Incident createdIncident = incidentRepository.createIncident(incidentVM);
                logger.info("Creating incident : " + createdIncident.toString());
            }

            // recuperation et traitement des incidents
            List<Incident> incidentToDecreaseIntensity_list = incidentToOff.fetchIncidentsToOff();
            for (Incident incidentItem : incidentToDecreaseIntensity_list) {

                Incident newIncident = incidentRepository.updateIncidentIntensity(incidentItem, incidentItem.getIntensity() - 1);
                logger.info("Updated Incident from {} to {}", incidentItem, newIncident);
            }

            // recuperation et traitement des trucks
            List<Truck> trucks = this.truckRepository.getTrucks();
            logger.info("Starting moving trucks");
            for (Truck truck : trucks) {
                truckToMove.moveTruck(truck);
            }

            //Pause de 5 secondes
            Thread.sleep(clockRate);
        }


    }
}
