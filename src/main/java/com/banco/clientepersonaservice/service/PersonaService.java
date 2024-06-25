package com.banco.clientepersonaservice.service;

import com.banco.clientepersonaservice.entity.Persona;
import com.banco.clientepersonaservice.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deleteById(Long id) {
        if(personaRepository.existsById(id)) {
            personaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Persona no encontrada con id: " + id);
        }
    }
}