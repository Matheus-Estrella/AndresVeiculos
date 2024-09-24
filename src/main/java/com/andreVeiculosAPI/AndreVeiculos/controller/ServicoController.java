package com.andreVeiculosAPI.AndreVeiculos.controller;

import com.andreVeiculosAPI.AndreVeiculos.entities.Servico;
import com.andreVeiculosAPI.AndreVeiculos.services.ServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public record ServicoController(ServicoService servicoService) {

    @PostMapping
    public ResponseEntity<Servico> createServico(@RequestBody Servico servico) {
        Servico savedServico = servicoService.save(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedServico);
    }

    @GetMapping
    public ResponseEntity<List<Servico>> getAllServicos() {
        List<Servico> servicos = servicoService.findAll();
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable Long id) {
        Servico servico = servicoService.findById(id);
        if (servico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable Long id) {
        Servico servico = servicoService.findById(id);
        if (servico == null) {
            return ResponseEntity.notFound().build();
        }
        servicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
