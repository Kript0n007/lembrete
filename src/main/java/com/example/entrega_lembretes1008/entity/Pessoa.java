package com.example.entrega_lembretes1008.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
    @Data
@NoArgsConstructor
@AllArgsConstructor
    public class Pessoa {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
        private List<Lembrete> lembretes = new ArrayList<>();
    }

