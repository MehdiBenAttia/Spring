package com.example.mehdibenattia.Services;

import com.example.mehdibenattia.entities.Moniteur;

import java.util.List;
import java.util.Optional;

public interface IMoniteurService {


    List<Moniteur> retrieveAllMoniteurs();
    Moniteur addMoniteur(Moniteur moniteur);
    Moniteur updateMoniteur (Moniteur moniteur);
    Optional<Moniteur> retrieveMoniteur (Long numMoniteur);
    void removeMoniteur  (Long numMoniteur);
}
