package simulator.projet.repository;

import simulator.projet.model.Barrack;

import java.util.List;

public interface IBarrackRepository {


    List<Barrack> getBarracks();

    Barrack createBarrack(Barrack barrack);

}
