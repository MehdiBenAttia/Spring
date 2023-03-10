package com.example.mehdibenattia.Controller;

import com.example.mehdibenattia.entities.TypeAbonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.example.mehdibenattia.Services.IAbonnementService;
import com.example.mehdibenattia.entities.Abonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("abonnement")

public class AbonnementController {
    @Autowired
    IAbonnementService iAbonnementService;
    @GetMapping
    public List<Abonnement> getAll(){
        return iAbonnementService.retrieveAllAbonnement();

    }
    @GetMapping("{numAbon}")

    public Optional<Abonnement> retrieveAbonnement(@PathVariable Long numAbon) {

        return  iAbonnementService.retrieveAbonnement(numAbon);

    }
    @PostMapping

    public Abonnement addAbonnement(@RequestBody Abonnement abonnement){

        return iAbonnementService.addAbonnement(abonnement);
    }
    @DeleteMapping("{numAbon}")
    public void removeAbonnement(@PathVariable Long numAbon){

        iAbonnementService.removeAbonnement(numAbon);
    }

    @PutMapping
    public Abonnement updateAbonnement(@RequestBody Abonnement abonnement) {

        return  iAbonnementService.updateAbonnement(abonnement);

    }

    @GetMapping("abParType/{tp}")
    public List<Abonnement> getAbonnementParType(@PathVariable TypeAbonnement typeAbonnement){
        return  iAbonnementService.getSubscriptionByType(typeAbonnement);
    }

    @GetMapping("abParDate/{dateDebut}/{dateFin}")
    public List<Abonnement>getAbonnementParDate (@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate){
        return  iAbonnementService.retrieveSubscriptionsByDates(startDate,endDate);
    }
}
