package HR.example.HR.service.Departement;

import HR.example.HR.models.Departement;

import java.util.List;

public interface DepartementServiceInt {

 void addDepartement(Departement departement) ;

    Departement FindDepartementByID(Long id) ;

    List<Departement> findAllDepartement() ;

    void DeleteDepart(Long id) ;

    void updateDepartement(Long id , Departement updatedDepartement) ;
}
