package com.andreVeiculosAPI.AndreVeiculos.entities;


import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

@Entity
public record Veiculo(
                      @Id String placa,
                      String modelo,
                      String marca,
                      String cor,
                      double preco,
                      int anoFabricacao,
                      int anoModelo
){}

