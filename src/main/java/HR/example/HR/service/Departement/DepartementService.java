package HR.example.HR.service.Departement;

import HR.example.HR.models.Departement;
import HR.example.HR.models.repository.DepartementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DepartementService implements DepartementServiceInt {

    private final DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public void addDepartement(Departement departement) {
        departementRepository.save(departement);
    }

    public Departement FindDepartementByID(Long id) {
        Departement foundDepartement = departementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departement not found"));
        return foundDepartement;

    }
    public List<Departement> findAllDepartement(){
       return  departementRepository.findAll() ;
    }
    public void DeleteDepart(Long id){
        if(departementRepository.existsById(id)){
            departementRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Department not Found");
        }
    }

    public void updateDepartement(Long id ,Departement updatedDepartement){
        if(departementRepository.existsById(id)){
            updatedDepartement.setId(id);
            departementRepository.save(updatedDepartement) ;
        }else {
            throw new EntityNotFoundException("Department not found with id: " + id);
        }
    }
}
