package com.example.GestionRendezVous.services;


import com.example.GestionRendezVous.entities.RendezVous;
import com.example.GestionRendezVous.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RendezVousService {

    @Autowired
    private RendezVousRepository rendezVousRepository;

    // Create
    public RendezVous createRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    // Read all
    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }

    // Read one
    public Optional<RendezVous> getRendezVousById(Long id) {
        return rendezVousRepository.findById(id);
    }

    // Update
    public RendezVous updateRendezVous(Long id, RendezVous rendezVousDetails) {
        Optional<RendezVous> optionalRendezVous = rendezVousRepository.findById(id);
        if (optionalRendezVous.isPresent()) {
            RendezVous rendezVous = optionalRendezVous.get();
            rendezVous.setDateRendezVous(rendezVousDetails.getDateRendezVous());
            rendezVous.setIdPatient(rendezVousDetails.getIdPatient());
            rendezVous.setNomMedecin(rendezVousDetails.getNomMedecin());
            rendezVous.setMotif(rendezVousDetails.getMotif());
            return rendezVousRepository.save(rendezVous);
        }
        return null;
    }

    // Delete
    public boolean deleteRendezVous(Long id) {
        if (rendezVousRepository.existsById(id)) {
            rendezVousRepository.deleteById(id);
            return true;
        }
        return false;
    }
}