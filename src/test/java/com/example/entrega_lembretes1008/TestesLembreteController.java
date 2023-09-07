package com.example.entrega_lembretes1008;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;  // Correção aqui
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.example.entrega_lembretes1008.controller.PessoaController;
import com.example.entrega_lembretes1008.dto.LembreteDTO;
import com.example.entrega_lembretes1008.dto.PessoaDTO;
import com.example.entrega_lembretes1008.service.LembreteService;
import com.example.entrega_lembretes1008.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TestesLembreteController {

    @Mock
    private PessoaService pessoaService;

    @Mock
    private LembreteService lembreteService;

    @InjectMocks
    private PessoaController pessoaController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        assertNotNull(pessoaService);
        assertNotNull(lembreteService);
        assertNotNull(pessoaController);
        mockMvc = MockMvcBuilders.standaloneSetup(pessoaController).build();
    }

    @Test
    public void testFindAll() throws Exception {
        List<LembreteDTO> lembretesJoao = Arrays.asList(new LembreteDTO("Lembrete1"), new LembreteDTO("Lembrete2"));
        List<LembreteDTO> lembretesMaria = Arrays.asList(new LembreteDTO("Lembrete3"));

        List<PessoaDTO> pessoas = Arrays.asList(
                new PessoaDTO("João", lembretesJoao),
                new PessoaDTO("Maria", lembretesMaria)
        );

        when(pessoaService.findAll()).thenReturn(pessoas);

        mockMvc.perform(get("/pessoas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nome", is("João")))
                .andExpect(jsonPath("$[0].lembretes", hasSize(2)))
                .andExpect(jsonPath("$[1].nome", is("Maria")))
                .andExpect(jsonPath("$[1].lembretes", hasSize(1)));
    }
}