package simulator.projet.repository;

import simulator.projet.model.Truck;

import java.util.List;

public interface ITruckRepository {

    List<Truck> getTrucks();

    Truck getTruck(int id);

    Truck createTruck(Truck truck);

    }
