package com.example.entrega_lembretes1008.service;

import com.example.entrega_lembretes1008.dto.LembreteDTO;
import com.example.entrega_lembretes1008.dto.PessoaDTO;
import com.example.entrega_lembretes1008.entity.Lembrete;
import com.example.entrega_lembretes1008.entity.Pessoa;
import com.example.entrega_lembretes1008.repository.LembreteRepository;
import com.example.entrega_lembretes1008.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private LembreteRepository lembreteRepository;


    public Pessoa createPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDTO.getNome());

        return pessoaRepository.save(pessoa);
    }

    public List<PessoaDTO> findAll() {
        List<Pessoa> pessoas = pessoaRepository.findAll();

        return pessoas.stream().map(pessoa -> {
            PessoaDTO dto = new PessoaDTO();
            dto.setNome(pessoa.getNome());

            List<LembreteDTO> lembretes = pessoa.getLembretes().stream().map(lembrete -> {
                LembreteDTO lembreteDTO = new LembreteDTO();
                lembreteDTO.setTexto(lembrete.getTexto());

                return lembreteDTO;
            }).collect(Collectors.toList());

            dto.setLembretes(lembretes);
            return dto;
        }).collect(Collectors.toList());
    }
    public PessoaDTO getPessoaComLembretesPorNome(String nome) {
        Pessoa pessoa = pessoaRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        PessoaDTO dto = new PessoaDTO();
        dto.setNome(pessoa.getNome());

        List<LembreteDTO> lembreteDTOs = pessoa.getLembretes().stream().map(lembrete -> {
            LembreteDTO lembreteDTO = new LembreteDTO();
            lembreteDTO.setTexto(lembrete.getTexto());
            return lembreteDTO;
        }).collect(Collectors.toList());

        dto.setLembretes(lembreteDTOs);
        return dto;
    }

}
