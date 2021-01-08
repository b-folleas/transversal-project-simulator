package simulator.projet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import simulator.projet.repository.Irepository.IMapRepository;
import simulator.projet.service.Iservice.*;

@Component
public class Main implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private final IMapRepository mapRepository;
    private final ISimulatorInitializer simulatorInitializer;
    private final ISimulatorRunner simulatorRunner;


    public Main(IMapRepository mapRepository,
                ISimulatorInitializer simulatorInitializer,
                ISimulatorRunner simulatorRunner) {

        this.mapRepository = mapRepository;
        this.simulatorInitializer = simulatorInitializer;
        this.simulatorRunner = simulatorRunner;
    }

    @Override
    public void run(String... args) throws InterruptedException {
        this.mapRepository.getMapItems();

        logger.info("Launching initialisation");
        simulatorInitializer.seedManager();

        logger.info("Starting runner");
        simulatorRunner.runner();
    }


}
