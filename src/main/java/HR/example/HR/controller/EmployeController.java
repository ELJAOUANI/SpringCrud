package HR.example.HR.controller;

import HR.example.HR.models.Employe;
import HR.example.HR.service.Employe.EmployeServiceInt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/employe")
public class EmployeController {

   private final EmployeServiceInt employeServiceInt;

    public EmployeController(EmployeServiceInt employeServiceInt) {
        this.employeServiceInt = employeServiceInt;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEmploye (@RequestBody Employe employe){
       employeServiceInt.saveEmploye(employe);
                return ResponseEntity.ok("Employe Ajouté");

    }

    @GetMapping("/{id}")
    public  ResponseEntity<Employe> findEmployeById (@PathVariable Long id){
        Employe foundEmploye = employeServiceInt.findEmployeById(id);
        return ResponseEntity.ok(foundEmploye);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employe>> getAllEmployees () {
        return ResponseEntity.ok(employeServiceInt.findAllEmployees());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeById(@PathVariable Long id) {
        employeServiceInt.deleteEmployeById(id);
        return ResponseEntity.ok("Employe Supprimé avec succès");
    }
//    @PutMapping("/update")
//    public ResponseEntity<String> updateEmploye(@RequestBody Employe updatedEmploye) {
//        employeServiceInt.updateEmploye(updatedEmploye);
//        return ResponseEntity.ok("Employe Mis à jour avec succès");
//    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmploye(@PathVariable Long id, @RequestBody Employe updatedEmploye) {
        employeServiceInt.updateEmploye(id, updatedEmploye);
        return ResponseEntity.ok("Employe Mis à jour avec succès");
    }
}
