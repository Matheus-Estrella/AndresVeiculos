package com.andreVeiculosAPI.AndreVeiculos.services;


import com.andreVeiculosAPI.AndreVeiculos.entities.Servico;
import com.andreVeiculosAPI.AndreVeiculos.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record ServicoService(ServicoRepository servicoRepository) {

    public List<Servico> findAll(){
        return servicoRepository.findAll();
    }

    public Servico save(Servico servico){
        return servicoRepository.save(servico);
    }

    public Servico findById(Long id){
        return servicoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
         servicoRepository.deleteById(id);
    }


}