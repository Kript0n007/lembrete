package com.example.entrega_lembretes1008.dto;

import lombok.Data;

import java.util.List;

@Data
public class PessoaDTO {
    private String nome;
    private List<LembreteDTO> lembretes;
}
