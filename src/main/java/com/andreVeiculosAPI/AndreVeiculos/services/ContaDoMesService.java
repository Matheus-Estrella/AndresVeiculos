package com.andreVeiculosAPI.AndreVeiculos.services;

import com.andreVeiculosAPI.AndreVeiculos.entities.ContasDoMes;
import com.andreVeiculosAPI.AndreVeiculos.repository.ContaDoMesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record ContaDoMesService(ContaDoMesRepository contaDoMesRepository) {

    public List<ContasDoMes> findAll()  {
        return contaDoMesRepository.findAll();
    }

    public ContasDoMes save(ContasDoMes contasDoMes){
        return contaDoMesRepository.save(contasDoMes);
    }

    public Optional<ContasDoMes> findById(long id) {
        return contaDoMesRepository.findById(id);
    }

    public void deleteById(Long id){
        contaDoMesRepository.deleteById(id);
    }
}
