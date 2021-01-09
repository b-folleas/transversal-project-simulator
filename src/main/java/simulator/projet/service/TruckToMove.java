package simulator.projet.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import simulator.projet.model.Incident;
import simulator.projet.model.MapItem;
import simulator.projet.model.Truck;
import simulator.projet.repository.Irepository.ITruckRepository;
import simulator.projet.service.Iservice.ITruckToMove;

import java.util.Optional;

@Service
public class TruckToMove implements ITruckToMove {

    private static final Logger logger = LoggerFactory.getLogger(TruckToMove.class);
    private final ITruckRepository truckRepository;


    public TruckToMove(ITruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public void moveTruck(Truck truck) {

        // Lorsque un truck se rend sur un incident il n'est pas disponible.
        if (!truck.isAvailability()) {
            //on recupere les incidents assigne au truck
            Optional<Incident> truckAssignedIncident = truck.getIncidents().stream().filter(m -> m.getIntensity() > 0).findFirst();
            if (truckAssignedIncident.isPresent()) {
                MapItem newMapItem = truck.getMapItem();

                int posX = truck.getMapItem().getPosX();
                int posY = truck.getMapItem().getPosY();

                //On mesure la distance entre le truck et son incident sur X
                int distX = truckAssignedIncident.get().getMapItem().getPosX() - posX;
                if (distX != 0) {
                    // On avance en d une case
                    if (distX < 0) {
                        posX = newMapItem.getPosX() - 1;
                    } else {
                        posX = newMapItem.getPosX() + 1;
                    }
                    logger.info("Moving truck {} to : {},{}", truck.getId(), posX, posY);

                    truckRepository.updateTruck(truck.getId(), posX, posY);
                    return;
                }

                //Meme chose sur Y
                int distY = truckAssignedIncident.get().getMapItem().getPosY() - posY;
                if (distY != 0) {
                    if (distY < 0) {
                        posY = newMapItem.getPosY() - 1;
                    } else {
                        posY = newMapItem.getPosY() + 1;
                    }

                    truckRepository.updateTruck(truck.getId(), posX, posY);
                    logger.info("Moving truck {} to : {},{}", truck.getId(), posX, posY);
                }


            }
        } else if (!truck.getMapItem().getId().equals(truck.getBarrack().getMapItem().getId())) {
            // Dans le cas ou le truck est disponible il faut le faire de déplacer vers sa barrack.

            int posX = truck.getMapItem().getPosX();
            int posY = truck.getMapItem().getPosY();

            int posXBarrack = truck.getBarrack().getMapItem().getPosX();
            int posYBarrack = truck.getBarrack().getMapItem().getPosY();

            int distX = posXBarrack - posX;
            int distY = posYBarrack - posY;

            if (distX != 0) {
                // On avance en d une case
                if (distX < 0) {
                    posX -= 1;
                } else {
                    posX += 1;
                }
                logger.info("Moving truck {} to : {},{}", truck.getId(), posX, posY);

                truckRepository.updateTruck(truck.getId(), posX, posY);
                return;
            }

            if (distY != 0) {
                if (distY < 0) {
                    posY -= 1;
                } else {
                    posY += 1;
                }

                truckRepository.updateTruck(truck.getId(), posX, posY);
                logger.info("Moving truck {} to : {},{}", truck.getId(), posX, posY);
            }
        }
    }
}
