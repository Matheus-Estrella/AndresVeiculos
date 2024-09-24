package com.andreVeiculosAPI.AndreVeiculos.controller;

import com.andreVeiculosAPI.AndreVeiculos.entities.Veiculo;
import com.andreVeiculosAPI.AndreVeiculos.services.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public record VeiculoController(VeiculoService veiculoService) {

    @PostMapping
    public ResponseEntity<Veiculo> createVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo savedVeiculo = veiculoService.save(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVeiculo);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAllVeiculos() {
        List<Veiculo> veiculos = veiculoService.findAll();
        return ResponseEntity.ok(veiculos);
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable String placa) {
        Veiculo veiculo = veiculoService.findById(placa);
        if (veiculo == null) {
            return ResponseEntity.notFound().build();
        }
        veiculoService.deleteById(placa);
        return ResponseEntity.noContent().build();
    }
}
