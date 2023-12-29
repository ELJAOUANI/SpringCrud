package HR.example.HR.service.Employe;

import HR.example.HR.models.Employe;

import java.util.List;

public interface EmployeServiceInt {

    void saveEmploye (Employe employe);

    Employe findEmployeById (Long id);


    List<Employe> findAllEmployees ();

    void deleteEmployeById(Long id);

//    void updateEmploye(Employe updatedEmploye);
    void updateEmploye(Long id, Employe updatedEmploye);
}
