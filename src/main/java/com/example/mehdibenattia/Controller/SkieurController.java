package com.example.mehdibenattia.Controller;

import com.example.mehdibenattia.entities.TypeAbonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mehdibenattia.Services.ISkieurService;
import com.example.mehdibenattia.entities.Skieur;

import java.util.List;

@RestController
@RequestMapping("/skieur")
public class SkieurController {
    @Autowired
    ISkieurService iSkieurService;
    //localhost:9090/retrieveAllSkieurs


    public List<Skieur> getAll(){
        return iSkieurService.retrieveAllSkieurs();
    }
    @GetMapping("{numSkieur}")
    public Skieur retrieveSkieur(@PathVariable Long numSkieur) {
        return iSkieurService.retrieveSkieur(numSkieur);
    }
    @PostMapping(/*path ="addSkieur"*/) //ena aandi post barka edheka aaleh ma nesthakhech, wahdou bech yaarfou li ena bech naamel add
    public Skieur addSkieur(@RequestBody Skieur skieur){

        return iSkieurService.addSkieur(skieur);
    }
    @PutMapping
    public Skieur updateSkieur(@RequestBody Skieur skieur) {
        return iSkieurService.updateSkieur(skieur);
    }
    @DeleteMapping("{numSkieur}")
    public void removeSkieur(@PathVariable Long numSkieur) {
        iSkieurService.removeSkieur(numSkieur);
    }
    @PutMapping("/{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable Long numSkieur, @PathVariable Long numPiste){
        return iSkieurService.assignSkierToPiste(numSkieur, numPiste);
    }
    @PutMapping("/{numSkieur}/{numAbon}")
    public Skieur AssignSkierToSubscription(long numSkieur, long numAbon){
        return iSkieurService.AssignSkierToSubscription(numSkieur, numAbon);
    }

    @GetMapping("getSkieurParTypeAbon/{tp}")
    public List<Skieur> getSkieurParTypeAbon(@PathVariable TypeAbonnement typeAbonnement){
        return  iSkieurService.retrieveSkiersBySubscriptionType(typeAbonnement);
    }
}
