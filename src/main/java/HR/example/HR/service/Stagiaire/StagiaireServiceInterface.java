package HR.example.HR.service.Stagiaire;


import HR.example.HR.models.Stagiaire;

import java.util.List;

public interface StagiaireServiceInterface {
    void addStagiaire (Stagiaire stagiaire);

    Stagiaire getStagiareById (Long id);


    List<Stagiaire> findAllStagiare ();

    void deleteStagiare(Long id);

    void updateStagiare(Long id, Stagiaire updatedStagiare);


}