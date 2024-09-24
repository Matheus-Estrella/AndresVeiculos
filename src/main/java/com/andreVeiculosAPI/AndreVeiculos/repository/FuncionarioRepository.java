package com.andreVeiculosAPI.AndreVeiculos.repository;

import com.andreVeiculosAPI.AndreVeiculos.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
