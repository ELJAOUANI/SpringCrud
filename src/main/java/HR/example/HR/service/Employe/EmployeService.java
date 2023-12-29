package HR.example.HR.service.Employe;

import HR.example.HR.models.Employe;
import HR.example.HR.models.repository.EmployeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService implements EmployeServiceInt {

    private final EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {

        this.employeRepository = employeRepository;
    }



    public void saveEmploye(Employe employe) {
        employeRepository.save(employe);
    }

    public Employe findEmployeById(Long id) {
        Employe foundEmploye = employeRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Employe Not found"));
        return foundEmploye;
    }

    public List<Employe>findAllEmployees(){

        return employeRepository.findAll();
    }
    public void deleteEmployeById(Long id) {
        if (employeRepository.existsById(id)) {
            employeRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Employe not found with id: " + id);
        }
    }

    public void updateEmploye(Long id, Employe updatedEmploye) {
        if (employeRepository.existsById(id)) {
            updatedEmploye.setId(id); // Ensure the ID is set in the updatedEmploye object
            employeRepository.save(updatedEmploye);
        } else {
            throw new EntityNotFoundException("Employe not found with id: " + id);
        }
    }
}
