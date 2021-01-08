package simulator.projet.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import simulator.projet.model.MapItem;
import simulator.projet.repository.Irepository.IMapRepository;

import java.util.List;

@Service
public class MapRepository extends BaseRepository<MapItem> implements IMapRepository {

    public MapRepository(@Value("${api.baseUrl}") String baseUrl, @Value("${api.baseUrlManager}") String baseUrlManager) {
        super(baseUrl,baseUrlManager);
    }

    @Override
    public List<MapItem> getMapItems(){
        return this.getList("/mapItems");
    }

    @Override
    Class<MapItem> getClassObject() {
        return MapItem.class;
    }
}
