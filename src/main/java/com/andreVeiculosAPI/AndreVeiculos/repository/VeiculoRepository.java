package com.andreVeiculosAPI.AndreVeiculos.repository;

import com.andreVeiculosAPI.AndreVeiculos.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository  extends JpaRepository<Veiculo, String> {
}
