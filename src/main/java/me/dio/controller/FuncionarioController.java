package me.dio.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import me.dio.model.Funcionario;
import me.dio.service.FuncionarioService;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {


private final FuncionarioService funcionarioService;
public FuncionarioController(FuncionarioService funcionarioService) {
    this.funcionarioService = funcionarioService;
}

@GetMapping("/{id}")
public Funcionario findById(@PathVariable long id) {
    return funcionarioService.findById(id);

}

@PostMapping
public ResponseEntity<Funcionario> create(@Valid @RequestBody Funcionario funcionarioToCreate){

    var FuncionarioCadastrado = funcionarioService.create(funcionarioToCreate);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(FuncionarioCadastrado.getId())
                .toUri();
                return ResponseEntity.created(location).body(FuncionarioCadastrado);  
}

@DeleteMapping("/{id}")
public Funcionario Delete(@PathVariable long id) {
    return funcionarioService.Delete(id);
}

@PutMapping("/{id}")
public Funcionario Update(@PathVariable long id, @Valid @RequestBody Funcionario funcionarioToUpdate) {
    return funcionarioService.Update(id, funcionarioToUpdate);
}
}