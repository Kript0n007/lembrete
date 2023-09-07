package com.example.entrega_lembretes1008.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LembreteDTO {
    private String texto;

    public String getTexto() {
        return texto;
    }
}
