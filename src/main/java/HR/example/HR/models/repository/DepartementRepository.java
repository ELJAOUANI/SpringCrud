package HR.example.HR.models.repository;

import HR.example.HR.models.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Long > {
}
