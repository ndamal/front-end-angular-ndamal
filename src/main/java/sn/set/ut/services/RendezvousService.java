package sn.set.ut.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.set.ut.exeptions.RVNotFoundExeption;
import sn.set.ut.models.RendezVous;
import sn.set.ut.repositories.RendezVousRepo;

import java.util.List;
import java.util.UUID;

@Service
public class RendezvousService {
    @Autowired
    private RendezVousRepo rendezVousRepo;

    public RendezVous ajouterRv(RendezVous rv){
        rv.setCodeRv(UUID.randomUUID().toString());
        return rendezVousRepo.save(rv);
    }

    public List<RendezVous> getAllRvs(){
        return rendezVousRepo.findAll();
    }

    public void supprimerRvById(Long id){
        rendezVousRepo.deleteById(id);
    }

    public RendezVous trouverRvById(Long id){
        return rendezVousRepo.findById(id).orElseThrow(() ->
                new RVNotFoundExeption("Un RV avec ID: "+ id +"n'existe pas !!"));
    }

    public RendezVous updateRv(RendezVous rv){
        return rendezVousRepo.save(rv);
    }
}
