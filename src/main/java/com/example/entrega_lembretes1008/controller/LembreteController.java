package com.example.entrega_lembretes1008.controller;

import com.example.entrega_lembretes1008.dto.LembreteDTO;
import com.example.entrega_lembretes1008.entity.Lembrete;
import com.example.entrega_lembretes1008.entity.Pessoa;
import com.example.entrega_lembretes1008.repository.LembreteRepository;
import com.example.entrega_lembretes1008.repository.PessoaRepository;
import com.example.entrega_lembretes1008.service.LembreteService;
import com.example.entrega_lembretes1008.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lembretes")
public class LembreteController {

    @Autowired
    private LembreteRepository lembreteRepository;
    @Autowired
    private LembreteService lembreteService;

    @PostMapping("/{nomePessoa}")
    public ResponseEntity<Lembrete> createLembrete(@PathVariable String nomePessoa, @RequestBody LembreteDTO lembreteDTO) {
        Lembrete lembrete = lembreteService.createLembrete(nomePessoa, lembreteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(lembrete);
    }

    @DeleteMapping("/{lembreteId}")
    public ResponseEntity<Void> deleteLembrete(@PathVariable Long lembreteId) {
        lembreteService.deleteLembrete(lembreteId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{lembreteId}")
    public ResponseEntity<Lembrete> updateLembrete(@PathVariable Long lembreteId, @RequestBody LembreteDTO lembreteDTO) {
        Lembrete updatedLembrete = lembreteService.updateLembrete(lembreteId, lembreteDTO);
        return ResponseEntity.ok(updatedLembrete);
    }


}
