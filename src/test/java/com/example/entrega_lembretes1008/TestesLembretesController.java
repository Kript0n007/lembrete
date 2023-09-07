package com.example.entrega_lembretes1008;

import com.example.entrega_lembretes1008.controller.LembreteController;
import com.example.entrega_lembretes1008.dto.LembreteDTO;
import com.example.entrega_lembretes1008.entity.Lembrete;
import com.example.entrega_lembretes1008.repository.LembreteRepository;
import com.example.entrega_lembretes1008.service.LembreteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LembreteController.class)
public class TestesLembretesController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private LembreteService lembreteService;

    @MockBean
    private LembreteRepository lembreteRepository;

    private LembreteDTO lembreteDTO;
    private Lembrete lembrete;

    private String nomePessoa = "ExemploPessoa";
    private Long lembreteId = 1L;

    @BeforeEach
    void setUp() {
        lembreteDTO = new LembreteDTO("Descrição do lembrete");
//        lembrete = new Lembrete(lembreteId,lembreteDTO.getTexto());
    }

    @Test
    void testCreateLembrete() throws Exception {
        when(lembreteService.createLembrete(nomePessoa, lembreteDTO)).thenReturn(lembrete);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/lembretes/{nomePessoa}", nomePessoa)
                        .content(objectMapper.writeValueAsString(lembreteDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        verify(lembreteService, times(1)).createLembrete(nomePessoa, lembreteDTO);
    }

    @Test
    void testDeleteLembrete() throws Exception {
        doNothing().when(lembreteService).deleteLembrete(lembreteId);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/lembretes/{lembreteId}", lembreteId))
                .andExpect(status().isNoContent());

        verify(lembreteService, times(1)).deleteLembrete(lembreteId);
    }

    @Test
    void testUpdateLembrete() throws Exception {
        when(lembreteService.updateLembrete(lembreteId, lembreteDTO)).thenReturn(lembrete);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/lembretes/{lembreteId}", lembreteId)
                        .content(objectMapper.writeValueAsString(lembreteDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(lembreteService, times(1)).updateLembrete(lembreteId, lembreteDTO);
    }
}
