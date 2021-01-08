package simulator.projet.service.Iservice;


import org.springframework.stereotype.Service;
import simulator.projet.model.viewModel.IncidentViewModel;

import java.util.List;

public interface IIncidentChecker {
    List<IncidentViewModel> incidentsToGenerate();

}
