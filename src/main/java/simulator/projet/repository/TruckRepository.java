package simulator.projet.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import simulator.projet.model.Truck;

import java.util.List;

@Component
public class TruckRepository extends BaseRepository<Truck> implements ITruckRepository {

    public TruckRepository(@Value("${api.baseUrl}") String baseUrl) {
        super(baseUrl);
    }

    @Override
    Class<Truck> getClassObject() {
        return Truck.class;
    }

    @Override
    public List<Truck> getTrucks() {
        return this.getList("/trucks");
    }

    @Override
    public Truck getTruck(int id) {
        return this.getItem("/truck/" + id);
    }
}
