package HR.example.HR.controller;

import HR.example.HR.models.Stagiaire;
import HR.example.HR.service.Stagiaire.StagiaireServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stagiaire")
public class StagiaireController {
    private final StagiaireServiceInterface stagiaireServiceInterface;

    public StagiaireController(StagiaireServiceInterface stagiaireServiceInterface){
        this.stagiaireServiceInterface = stagiaireServiceInterface ;
    }
    @PostMapping("/add")
    public ResponseEntity<String> addStagiaire(@RequestBody Stagiaire stagiare){
        stagiaireServiceInterface.addStagiaire(stagiare);
        return  ResponseEntity.ok("Successfully inserting");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Stagiaire> getStagiareById(@PathVariable Long id){
        Stagiaire foundStagiaire = stagiaireServiceInterface.getStagiareById(id);
        return ResponseEntity.ok(foundStagiaire);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Stagiaire>> getAllStagiares(){
        return ResponseEntity.ok(stagiaireServiceInterface.findAllStagiare());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStagiareById(@PathVariable Long id){
        stagiaireServiceInterface.deleteStagiare(id);
        return ResponseEntity.ok("Stagiaire Suprimer avec succes");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStagiare(@PathVariable Long id ,@RequestBody Stagiaire updatedStagiare){
        stagiaireServiceInterface.updateStagiare(id, updatedStagiare);
        return ResponseEntity.ok("Stagiare Mis a jour avec succes");
    }
}



