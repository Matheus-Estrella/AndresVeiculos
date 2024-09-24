package com.andreVeiculosAPI.AndreVeiculos.services;

import com.andreVeiculosAPI.AndreVeiculos.entities.Funcionario;
import com.andreVeiculosAPI.AndreVeiculos.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record FuncionarioService (FuncionarioRepository funcionarioRepository){

    public Funcionario save(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario findById(Long id){
        return funcionarioRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        funcionarioRepository.deleteById(id);
    }

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }





}
