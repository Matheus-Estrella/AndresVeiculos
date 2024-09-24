package com.andreVeiculosAPI.AndreVeiculos.controller;

import com.andreVeiculosAPI.AndreVeiculos.entities.Funcionario;
import com.andreVeiculosAPI.AndreVeiculos.services.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public record FuncionarioController(FuncionarioService funcionarioService) {

    @PostMapping
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario savedFuncionario = funcionarioService.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFuncionario);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> getAllFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.findAll();
        return ResponseEntity.ok(funcionarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.findById(id);
        if (funcionario == null) {
            return ResponseEntity.notFound().build();
        }
        funcionarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
