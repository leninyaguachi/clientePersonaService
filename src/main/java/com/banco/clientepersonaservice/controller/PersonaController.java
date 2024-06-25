package com.banco.clientepersonaservice.controller;

import com.banco.clientepersonaservice.entity.Persona;
import com.banco.clientepersonaservice.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Optional<Persona> persona = personaService.findById(id);
        return persona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Persona createPersona(@Valid @RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @Valid @RequestBody Persona personaDetails) {
        Optional<Persona> persona = personaService.findById(id);
        if (persona.isPresent()) {
            Persona updatedPersona = persona.get();
            updatedPersona.setNombre(personaDetails.getNombre());
            updatedPersona.setGenero(personaDetails.getGenero());
            updatedPersona.setEdad(personaDetails.getEdad());
            updatedPersona.setIdentificacion(personaDetails.getIdentificacion());
            updatedPersona.setDireccion(personaDetails.getDireccion());
            updatedPersona.setTelefono(personaDetails.getTelefono());
            return ResponseEntity.ok(personaService.save(updatedPersona));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        Optional<Persona> persona = personaService.findById(id);
        if (persona.isPresent()) {
            personaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}