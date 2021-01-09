package simulator.projet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import simulator.projet.Main;
import simulator.projet.model.Barrack;
import simulator.projet.model.Ground;
import simulator.projet.model.MapItem;
import simulator.projet.model.Truck;
import simulator.projet.model.viewModel.BarrackViewModel;
import simulator.projet.model.viewModel.TruckViewModel;
import simulator.projet.repository.Irepository.IBarrackRepository;
import simulator.projet.repository.Irepository.IMapRepository;
import simulator.projet.repository.Irepository.ITruckRepository;
import simulator.projet.service.Iservice.ISimulatorInitializer;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimulatorInitializer implements ISimulatorInitializer {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private final ITruckRepository truckRepository;
    private final IMapRepository mapRepository;
    private final IBarrackRepository barrackRepository;
    private final RandomService randomService;


    @Value("${truckNumber}")
    private int truckNumber;

    @Value("${barrackNumber}")
    private int barrackNumber;

    public SimulatorInitializer(ITruckRepository truckRepository, IMapRepository mapRepository, IBarrackRepository barrackRepository, RandomService randomService) {

        this.truckRepository = truckRepository;
        this.barrackRepository = barrackRepository;
        this.mapRepository = mapRepository;
        this.randomService = randomService;

    }

    @Override
    public void seedManager() {

        List<Barrack> barrackList = this.barrackRepository.getBarracks();
        List<Truck> truckList = this.truckRepository.getTrucks();

        if (barrackList.isEmpty()) {

            logger.info("There is no barrack");

            List<MapItem> mapItemsList = this.mapRepository.getMapItems();
            List<MapItem> buildings = mapItemsList.stream().filter(m -> m.getGround() == Ground.BUILDING).collect(Collectors.toList());


            for (int i = 0; i < barrackNumber; i++) {
                int id = randomService.randInt(99);
                MapItem mapItem_building = buildings.get(randomService.randIndex(buildings));

                BarrackViewModel barrack = new BarrackViewModel(mapItem_building.getPosX(), mapItem_building.getPosY(), "barrack_00" + id);


                Barrack createdBarrack = this.barrackRepository.createBarrack(barrack);
                logger.info("Created barrack  : " + createdBarrack.toString());

            }

        }


        if (truckList.isEmpty()) {

            logger.info("There is no truck");

            List<MapItem> buildings = this.mapRepository.getMapItems().stream().filter(m -> m.getGround() == Ground.BUILDING).collect(Collectors.toList());

            for (int i = 0; i < truckNumber; i++) {

                MapItem mapItem_building = buildings.get(randomService.randIndex(buildings));

                barrackList = this.barrackRepository.getBarracks();
                int barrackIndex = randomService.randIndex(barrackList);
                Barrack assignedBarrack = barrackList.get(barrackIndex);


                int matricule = randomService.randInt(9999);

                TruckViewModel truck = new TruckViewModel(mapItem_building.getPosX(), mapItem_building.getPosY(), matricule, true, assignedBarrack);
                Truck createdTruck = this.truckRepository.createTruck(truck);
                logger.info("Created truck  : " + createdTruck.toString());

            }
        }
    }


}
