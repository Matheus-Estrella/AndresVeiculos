package com.andreVeiculosAPI.AndreVeiculos.repository;

import com.andreVeiculosAPI.AndreVeiculos.entities.ContasDoMes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContaDoMesRepository extends JpaRepository<ContasDoMes, Long> {
//    List<ContasDoMes> findByValorGreaterThan(Double valor); exemplo dudu
}
