package com.andreVeiculosAPI.AndreVeiculos.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity


public record ContasDoMes(
        @Id long id,
        String descricao,
        Double valor
) {}