package com.example.entrega_lembretes1008.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}