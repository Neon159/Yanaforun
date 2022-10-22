/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.yanaforun.controller;

import com.example.yanaforun.entity.Materiales;
import com.example.yanaforun.service.MaterialesService;
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
@RequestMapping("/materiales")
@Api(value = "Microservicio de materiales", description = "Microservicio de materiales")
public class MaterialesController {
    

    @Autowired
    MaterialesService materialesService;

    @ApiOperation(value = "Listar de materiales")
     @GetMapping("/all")
    public List<Materiales> findAll() {
        return (List<Materiales>) materialesService.findAll();
    }

    @ApiOperation(value = "Datos existentes de materiales")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Materiales> findById(@PathVariable Long id) {
        Materiales materiales = materialesService.findById(id);
        return ResponseEntity.ok(materiales);
    }

    @ApiOperation(value = "registrar materiales")
    @PostMapping
    public Materiales save(@RequestBody Materiales materiales) {
        return materialesService.save(materiales);
    }
    @ApiOperation(value = "Modificar materiales")
    @PutMapping("/update")
    public Materiales update(@RequestBody Materiales materiales){
        return materialesService.save(materiales);
    }
    @ApiOperation(value = "Eliminar materiales")
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        materialesService.deleteById(id);
    }
}
