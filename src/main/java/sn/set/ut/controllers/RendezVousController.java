package sn.set.ut.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.set.ut.models.RendezVous;
import sn.set.ut.services.RendezvousService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
@Api(description = "API sur des opérations CRUD sur des Rendez-Vous.")
public class RendezVousController {

    @Autowired
    private RendezvousService rendezvousService;

    /*@GetMapping("/")
    public String index(){
        return "Bienvenue sur mon backend";
    }*/

    @ApiOperation(value = "Récupérer tous les Rendez-Vous !")
    @GetMapping(value = {
            "/",
            "/getrvs"
    })
    public ResponseEntity<List<RendezVous>> getAllRvs(){
        List<RendezVous> rvs= rendezvousService.getAllRvs();
        return new ResponseEntity<List<RendezVous>>(rvs,HttpStatus.OK);
    }

    @ApiOperation(value = "Chercher un Rendez-Vous par son ID!")
    @GetMapping("/chercher/{id}")
    public ResponseEntity<RendezVous> chercherRv(@PathVariable("id") Long id){
        RendezVous rv= rendezvousService.trouverRvById(id);
        return new ResponseEntity<RendezVous>(rv,HttpStatus.OK);
    }

    @ApiOperation(value = "Supprimer un Rendez-Vous !")
    @DeleteMapping("/supprimer/{id}")
    public void supprimerRv(@PathVariable("id") Long id){
        rendezvousService.supprimerRvById(id);
    }

    @ApiOperation(value = "Ajouter un Rendez-Vous !")
    @PostMapping("/ajouter")
    public ResponseEntity<RendezVous> ajouterRv(@RequestBody RendezVous rv){
        RendezVous newRv = rendezvousService.ajouterRv(rv);
        return new ResponseEntity<RendezVous>(newRv,HttpStatus.OK);
    }

    @ApiOperation(value = "Mise à jour d'un Rendez-Vous !")
    @PutMapping("/update")
    public ResponseEntity<RendezVous> updateRv(@RequestBody RendezVous rv){
        RendezVous newRv = rendezvousService.updateRv(rv);
        return new ResponseEntity<RendezVous>(newRv,HttpStatus.OK);
    }
}
