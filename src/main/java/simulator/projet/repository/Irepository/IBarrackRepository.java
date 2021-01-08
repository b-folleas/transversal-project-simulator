package simulator.projet.repository.Irepository;

import simulator.projet.model.Barrack;
import simulator.projet.model.viewModel.BarrackViewModel;

import java.util.List;

public interface IBarrackRepository {

    List<Barrack> getBarracks();

    Barrack createBarrack(BarrackViewModel barrack);

}
