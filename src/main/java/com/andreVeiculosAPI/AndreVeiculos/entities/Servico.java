package com.andreVeiculosAPI.AndreVeiculos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
public record Servico(

        @Id long id,
        String descricao,
        Date dtCadastro
) {}
