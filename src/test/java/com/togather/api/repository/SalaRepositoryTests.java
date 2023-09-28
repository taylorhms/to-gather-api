package com.togather.api.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.togather.api.ToGatherApiApplicationTests;
import com.togather.api.entity.Sala;
import com.togather.api.entity.Usuario;

public class SalaRepositoryTests extends ToGatherApiApplicationTests {
    
    private MockMvc mockMvc;

    @Autowired
    SalaRepository salaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
	void deveriaInserirUmaSalaNoBanco() {
		Sala sala = new Sala();
        sala.setId(1L);
        sala.setNome("Sala 1");
		assertEquals(sala, salaRepository.save(sala));
	}

    @Test
    void deveriaListarTodasAsSalasNoBanco() {
        Sala sala_1 = new Sala();
        sala_1.setId(1L);
        sala_1.setNome("Sala 1");
        salaRepository.save(sala_1);
        Sala sala_2 = new Sala();
        sala_2.setId(2L);
        sala_2.setNome("Sala 1");
        salaRepository.save(sala_2);
		assertEquals(2, salaRepository.findAll().size());
    }

    @Test
    void deveriaAdicionarUsuariosEmUmaSala() {
        Sala sala = new Sala();
        sala.setId(1L);
        sala.setNome("Sala 1");
		salaRepository.save(sala);

        Usuario usuario1 = new Usuario(null, "Usuario 1", "usuario1", "senha", "azul", "azul", null);
        Usuario usuario2 = new Usuario(null, "Usuario 2", "usuario2", "senha", "azul", "azul", null);
        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
        List<Usuario> lista = new java.util.ArrayList<>();
        lista.add(usuario1);
        lista.add(usuario2);
        sala.setUsuarios(lista);
        salaRepository.save(sala);

        assertEquals(2, salaRepository.findById(sala.getId()).get().getUsuarios().size());
    }
}
