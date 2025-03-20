package me.dio.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import me.dio.model.Departamento;
import me.dio.service.DepartamentService;

@RestController
@RequestMapping("/Departamentos")
public class DepartamentController {

private final DepartamentService departamentService;
public DepartamentController(DepartamentService departamentService) {
    this.departamentService = departamentService;
}
@GetMapping("/{id}")
public Departamento findById(@PathVariable long id) {
    return departamentService.findById(id);

} 

@PostMapping
public ResponseEntity<Departamento> create(@Valid @RequestBody Departamento DepartamentoToCreate){

    var DepartamentoCadastrado = departamentService.create(DepartamentoToCreate);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(DepartamentoCadastrado.getId())
                .toUri();

                return ResponseEntity.created(location).body(DepartamentoCadastrado);

    
}

}
