package com.example.entrega_lembretes1008.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
    private String nome;
    private List<LembreteDTO> lembretes;
}
