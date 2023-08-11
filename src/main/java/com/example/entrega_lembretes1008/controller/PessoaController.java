package com.example.entrega_lembretes1008.controller;

import com.example.entrega_lembretes1008.dto.LembreteDTO;
import com.example.entrega_lembretes1008.dto.PessoaDTO;
import com.example.entrega_lembretes1008.entity.Lembrete;
import com.example.entrega_lembretes1008.entity.Pessoa;
import com.example.entrega_lembretes1008.repository.PessoaRepository;
import com.example.entrega_lembretes1008.service.LembreteService;
import com.example.entrega_lembretes1008.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private LembreteService lembreteService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll() {
        List<PessoaDTO> pessoas = pessoaService.findAll();
        return ResponseEntity.ok(pessoas);
    }

    @PostMapping("/create")
    public ResponseEntity<Pessoa> createPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaService.createPessoa(pessoaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<PessoaDTO> getPessoaComLembretesPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(pessoaService.getPessoaComLembretesPorNome(nome));
    }



}
