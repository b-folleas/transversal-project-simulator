package simulator.projet.repository;

import org.springframework.stereotype.Service;
import simulator.projet.model.MapItem;

import java.util.List;

@Service
public interface IMapRepository {

    List<MapItem> getMapItems();
}
