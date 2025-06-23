package com.example.GestionRendezVous.controllers;

import com.example.GestionRendezVous.entities.RendezVous;
import com.example.GestionRendezVous.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rendezvous")
public class RendezVousController {

    @Autowired
    private RendezVousService rendezVousService;

    // Create
    @PostMapping
    public ResponseEntity<RendezVous> createRendezVous(@RequestBody RendezVous rendezVous) {
        RendezVous createdRendezVous = rendezVousService.createRendezVous(rendezVous);
        return new ResponseEntity<>(createdRendezVous, HttpStatus.CREATED);
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<RendezVous>> getAllRendezVous() {
        List<RendezVous> rendezVousList = rendezVousService.getAllRendezVous();
        return new ResponseEntity<>(rendezVousList, HttpStatus.OK);
    }

    // Read one
    @GetMapping("/{id}")
    public ResponseEntity<RendezVous> getRendezVousById(@PathVariable Long id) {
        Optional<RendezVous> rendezVous = rendezVousService.getRendezVousById(id);
        return rendezVous.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<RendezVous> updateRendezVous(@PathVariable Long id, @RequestBody RendezVous rendezVousDetails) {
        RendezVous updatedRendezVous = rendezVousService.updateRendezVous(id, rendezVousDetails);
        if (updatedRendezVous != null) {
            return new ResponseEntity<>(updatedRendezVous, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRendezVous(@PathVariable Long id) {
        boolean deleted = rendezVousService.deleteRendezVous(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
