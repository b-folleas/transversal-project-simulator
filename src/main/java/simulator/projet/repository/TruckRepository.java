package simulator.projet.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import simulator.projet.model.Truck;
import simulator.projet.model.viewModel.TruckViewModel;
import simulator.projet.repository.Irepository.ITruckRepository;

import java.util.List;

@Service
public class TruckRepository extends BaseRepository<Truck> implements ITruckRepository {

    public TruckRepository(@Value("${api.baseUrl}") String baseUrl, @Value("${api.baseUrlManager}") String baseUrlManager) {
        super(baseUrl, baseUrlManager);
    }


    @Override
    public List<Truck> getTrucks() {
        return this.getList("/trucks", true);
    }


    @Override
    public Truck createTruck(TruckViewModel truck) {
        return this.postItem("/truck", truck, TruckViewModel.class, true);
    }

    @Override
    public Truck updateTruck(Long truck_id, int posX, int posY) {
        return this.postItem("/truck/" + truck_id + "/posx/" + posX + "/posy/" + posY, "", Truck.class, true);
    }

    @Override
    public Truck getTruck(Long id) {
        return this.getItem("/truck/" + id, true);
    }


    @Override
    Class<Truck> getClassObject() {
        return Truck.class;
    }

}
