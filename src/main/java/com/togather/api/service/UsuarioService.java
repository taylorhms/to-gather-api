package com.togather.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.togather.api.dto.request.NovaContaDTO;
import com.togather.api.dto.response.UsuarioDTO;
import com.togather.api.entity.Usuario;
import com.togather.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    public Usuario findByLogin(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
    }

    public List<UsuarioDTO> todos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        
        return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }
    
    public UsuarioDTO novaConta(NovaContaDTO dados) throws Exception {
        Optional<Usuario> outro = usuarioRepository.findByLogin(dados.getLogin());

        if (outro.isPresent()) {
            throw new Exception("Nome de usuário já em uso");
        }

        Usuario novo = new Usuario();
        BeanUtils.copyProperties(dados, novo);
        novo.setSenha(encoder.encode(dados.getSenha()));
        usuarioRepository.save(novo);

        return new UsuarioDTO(novo);
    }
}
