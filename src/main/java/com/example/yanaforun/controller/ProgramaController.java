/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.yanaforun.controller;

import com.example.yanaforun.entity.Programa;
import com.example.yanaforun.service.ProgramaService;
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
@RequestMapping("/programa")
@Api(value = "Microservicio de programa", description = "Microservicio de programa")
public class ProgramaController {
    @Autowired
    ProgramaService programaService;

    @ApiOperation(value = "Lista de programa")
    @GetMapping
    public List<Programa> findAll() {
        return (List<Programa>) programaService.findAll();
    }

    @ApiOperation(value = "Datos existentes de programa")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Programa> findById(@PathVariable Long id) {
        Programa programa = programaService.findById(id);
        return ResponseEntity.ok(programa);
    }
@ApiOperation(value = "Modificar programa")
    @PutMapping("/update")
    public Programa update(@RequestBody Programa programa){
        return programaService.save(programa);
    }
    @ApiOperation(value = "registrar programa")
    @PostMapping
    public Programa save(@RequestBody Programa programa) {
        return programaService.save(programa);
    }

    @ApiOperation(value = "Eliminar programa")
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        programaService.deleteById(id);
    }
}
