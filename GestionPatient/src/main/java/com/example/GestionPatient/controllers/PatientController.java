package com.example.GestionPatient.controllers;

import com.example.GestionPatient.entities.Patient;
import com.example.GestionPatient.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Patient entities.
 */
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    /**
     * Create a new patient.
     * @param patient The patient to create.
     * @return The created patient.
     */
    @PostMapping
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) {
        Patient createdPatient = patientService.createPatient(patient);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    /**
     * Get all patients.
     * @return List of all patients.
     */
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    /**
     * Get a patient by ID.
     * @param id The ID of the patient.
     * @return The patient if found, or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        return patient != null ? new ResponseEntity<>(patient, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Update an existing patient.
     * @param id The ID of the patient to update.
     * @param patientDetails The updated patient details.
     * @return The updated patient.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @Valid @RequestBody Patient patientDetails) {
        Patient updatedPatient = patientService.updatePatient(id, patientDetails);
        return updatedPatient != null ? new ResponseEntity<>(updatedPatient, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Delete a patient by ID.
     * @param id The ID of the patient to delete.
     * @return Response indicating success.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Search patients by first name (prenom).
     * @param prenom The first name to search for.
     * @return List of patients matching the first name.
     */
    @GetMapping("/search")
    public ResponseEntity<List<Patient>> searchPatientsByPrenom(@RequestParam String prenom) {
        List<Patient> patients = patientService.searchPatientsByPrenom(prenom);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    /**
     * Get all patients sorted by age.
     * @return List of patients sorted by age.
     */
    @GetMapping("/sorted-by-age")
    public ResponseEntity<List<Patient>> getPatientsSortedByAge() {
        List<Patient> patients = patientService.getPatientsSortedByAge();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }
}