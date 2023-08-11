package com.example.entrega_lembretes1008.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
    @Data
    public class Pessoa {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
        private List<Lembrete> lembretes = new ArrayList<>();
    }

