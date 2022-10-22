/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.yanaforun.controller;

import com.example.yanaforun.entity.Persona;
import com.example.yanaforun.service.PersonaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author crnv_
 */
@RestController
@RequestMapping("/persona")
@Api(value = "Microservicio de persona", description = "Microservicio de persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @ApiOperation(value = "Lista de persona")
    @GetMapping
    public List<Persona> findAll() {
        return (List<Persona>) personaService.findAll();
    }

    @ApiOperation(value = "Datos existentes de persona")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Persona> findById(@PathVariable Long id) {
        Persona persona = personaService.findById(id);
        return ResponseEntity.ok(persona);
    }
@ApiOperation(value = "Actualizar persona")
    @PutMapping("/update")
    public Persona update(@RequestBody Persona persona){
        return personaService.save(persona);
    }

    @ApiOperation(value = "registrar una persona")
    @PostMapping
    public Persona save(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @ApiOperation(value = "Eliminar una persona")
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        personaService.deleteById(id);
    }
}
