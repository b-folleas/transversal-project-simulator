package simulator.projet.repository.Irepository;

import simulator.projet.model.Truck;
import simulator.projet.model.viewModel.TruckViewModel;

import java.util.List;


public interface ITruckRepository {

    List<Truck> getTrucks();

    Truck getTruck(Long id);

    Truck createTruck(TruckViewModel truck);

    Truck updateTruck(Long truck_id, int posX, int posY);

}
