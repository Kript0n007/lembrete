package com.example.entrega_lembretes1008.service;

import com.example.entrega_lembretes1008.dto.LembreteDTO;
import com.example.entrega_lembretes1008.entity.Lembrete;
import com.example.entrega_lembretes1008.entity.Pessoa;
import com.example.entrega_lembretes1008.repository.LembreteRepository;
import com.example.entrega_lembretes1008.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepository lembreteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Lembrete createLembrete(String nomePessoa, LembreteDTO lembreteDTO) {

        if (lembreteDTO.getTexto() == null || lembreteDTO.getTexto().trim().isEmpty()) {
            throw new IllegalArgumentException("O texto do lembrete não pode ser nulo ou vazio.");
        }

        Pessoa pessoa = pessoaRepository.findByNome(nomePessoa)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        Lembrete lembrete = new Lembrete();
        lembrete.setTexto(lembreteDTO.getTexto());
        lembrete.setPessoa(pessoa);

        pessoa.getLembretes().add(lembrete);

        return lembreteRepository.save(lembrete);
    }

    public void deleteLembrete(Long lembreteId) {
        if (!lembreteRepository.existsById(lembreteId)) {
            throw new RuntimeException("Lembrete não encontrado");
        }
        lembreteRepository.deleteById(lembreteId);
    }

    public Lembrete updateLembrete(Long lembreteId, LembreteDTO lembreteDTO) {
        Lembrete existingLembrete = lembreteRepository.findById(lembreteId)
                .orElseThrow(() -> new RuntimeException("Lembrete não encontrado"));

        if (lembreteDTO.getTexto() != null) {
            existingLembrete.setTexto(lembreteDTO.getTexto());
        }

        return lembreteRepository.save(existingLembrete);
    }

}
