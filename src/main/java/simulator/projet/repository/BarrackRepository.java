package simulator.projet.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import simulator.projet.model.Barrack;
import simulator.projet.model.viewModel.BarrackViewModel;
import simulator.projet.repository.Irepository.IBarrackRepository;

import java.util.List;

@Service
public class BarrackRepository extends BaseRepository<Barrack> implements IBarrackRepository {

    public BarrackRepository(@Value("${api.baseUrl}") String baseUrl, @Value("${api.baseUrlManager}") String baseUrlManager) {
        super(baseUrl,baseUrlManager);
    }

    @Override
    public List<Barrack> getBarracks() {
        return this.getList( "/barracks" , true);
    }

    @Override
    public Barrack createBarrack(BarrackViewModel barrack) {
        return this.postItem("/barrack", barrack , BarrackViewModel.class,  true);
    }

    @Override
    Class<Barrack> getClassObject() {
        return Barrack.class;
    }
}
