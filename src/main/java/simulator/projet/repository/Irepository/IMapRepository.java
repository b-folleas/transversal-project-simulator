package simulator.projet.repository.Irepository;

import org.springframework.stereotype.Service;
import simulator.projet.model.MapItem;

import java.util.List;

public interface IMapRepository {

    List<MapItem> getMapItems();
}
