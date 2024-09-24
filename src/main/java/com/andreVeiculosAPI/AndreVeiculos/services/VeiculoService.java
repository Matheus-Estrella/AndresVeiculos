package com.andreVeiculosAPI.AndreVeiculos.services;

import com.andreVeiculosAPI.AndreVeiculos.entities.Veiculo;
import com.andreVeiculosAPI.AndreVeiculos.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record VeiculoService (VeiculoRepository veiculoRepository){

    public List<Veiculo> findAll(){
        return veiculoRepository.findAll();
    }

    public Veiculo save(Veiculo veiculo){
        return veiculoRepository.save(veiculo);

    }

    public Veiculo findById(String placa){
        return veiculoRepository.findById(placa).orElse(null);
    }

    public void deleteById(String placa){
        veiculoRepository.deleteById(placa);
    }




}
