package com.andreVeiculosAPI.AndreVeiculos.controller;

import com.andreVeiculosAPI.AndreVeiculos.entities.ContasDoMes;
import com.andreVeiculosAPI.AndreVeiculos.services.ContaDoMesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contasdomes")
public record ContaDoMesController(ContaDoMesService contaDoMesService) {

    @PostMapping
    public ResponseEntity<ContasDoMes> createConta(@RequestBody ContasDoMes conta) {
        ContasDoMes savedConta = contaDoMesService.save(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedConta);
    }

    @GetMapping
    public ResponseEntity<List<ContasDoMes>> getAllContas() {
        List<ContasDoMes> contas = contaDoMesService.findAll();
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContasDoMes> getContaById(@PathVariable Long id) {
        Optional<ContasDoMes> conta = contaDoMesService.findById(id);
        return conta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConta(@PathVariable long id) {
        Optional<ContasDoMes> conta = contaDoMesService.findById(id);
        if (conta.isPresent()) {
            contaDoMesService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
