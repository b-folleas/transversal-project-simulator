package simulator.projet.service.Iservice;


import simulator.projet.model.viewModel.IncidentViewModel;

import java.util.List;

public interface IIncidentChecker {
    List<IncidentViewModel> incidentsToGenerate();

}
