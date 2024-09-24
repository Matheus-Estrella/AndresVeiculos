package com.andreVeiculosAPI.AndreVeiculos.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "")
public record Funcionario (
        @Id long id,
        String cpf,
        String nome,
        Double salario
) {}