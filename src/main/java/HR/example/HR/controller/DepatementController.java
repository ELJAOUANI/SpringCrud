package HR.example.HR.controller;

import HR.example.HR.models.Departement;
import HR.example.HR.service.Departement.DepartementServiceInt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departement")
public class DepatementController {
    private final DepartementServiceInt departementServiceInt ;

    public DepatementController(DepartementServiceInt departementServiceInt){
        this.departementServiceInt = departementServiceInt ;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDepartement(@RequestBody Departement departement){
        departementServiceInt.addDepartement(departement);
       return ResponseEntity.ok("Successfully inserting");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Departement>> getAllDepartement(){
        return ResponseEntity.ok(departementServiceInt.findAllDepartement());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departement> findDepartementById(Long id){
        Departement foundDepartement = departementServiceInt.FindDepartementByID(id);
        return ResponseEntity.ok(foundDepartement);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletDepartement(@PathVariable Long id){
        departementServiceInt.DeleteDepart(id);
       return ResponseEntity.ok("Depatment deleted successfully");
    }
@PutMapping("/{id}")
public ResponseEntity<String> updateDepartement(@PathVariable Long id ,@RequestBody Departement updatedDepartement){
        departementServiceInt.updateDepartement(id , updatedDepartement);
        return ResponseEntity.ok("Departement updated successfully") ;
}
}
