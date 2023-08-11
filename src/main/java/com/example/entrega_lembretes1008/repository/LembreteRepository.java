package com.example.entrega_lembretes1008.repository;

import com.example.entrega_lembretes1008.entity.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LembreteRepository extends JpaRepository<Lembrete, Long> {

}