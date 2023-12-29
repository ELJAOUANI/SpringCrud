package HR.example.HR.service.Stagiaire;

import HR.example.HR.models.Stagiaire;
import HR.example.HR.models.repository.StagiaireReposiitory;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StagiaireService implements StagiaireServiceInterface {
    private final StagiaireReposiitory stagiaireReposiitory ;
    public StagiaireService(StagiaireReposiitory stagiaireReposiitory){
        this.stagiaireReposiitory=stagiaireReposiitory ;
    }
    public void addStagiaire(Stagiaire stagiaire){
        stagiaireReposiitory.save(stagiaire);
    }

    public Stagiaire getStagiareById(Long id){
        Stagiaire findStagiare = stagiaireReposiitory.findById(id)
               .orElseThrow(()->new EntityNotFoundException("Employe Not found"));
                return findStagiare ;
    }

    public List<Stagiaire> findAllStagiare()
    {
        return stagiaireReposiitory.findAll();
    }

    public void deleteStagiare(Long id){
        if (stagiaireReposiitory.existsById(id)){
            stagiaireReposiitory.deleteById(id);
        }else {
            throw new EntityNotFoundException("Stagiare not Found Id :" + id);
        }
    }

    public void updateStagiare(Long id , Stagiaire updatedStagiare)
    {
        if (stagiaireReposiitory.existsById(id)){
            updatedStagiare.setId(id);
            stagiaireReposiitory.save(updatedStagiare);
        }else {
            throw new EntityNotFoundException("Emplye not found with id :" + id);
        }
    }
}
