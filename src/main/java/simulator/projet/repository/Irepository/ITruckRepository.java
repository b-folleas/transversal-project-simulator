package simulator.projet.repository.Irepository;

import org.springframework.stereotype.Service;
import simulator.projet.model.Truck;
import simulator.projet.model.viewModel.TruckViewModel;

import java.util.List;


public interface ITruckRepository {

    List<Truck> getTrucks();

    Truck getTruck(int id);

    Truck createTruck(TruckViewModel truck);

    Truck updateTruck(int truck_id, int posX, int posY) ;

    }
