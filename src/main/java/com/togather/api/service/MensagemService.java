package com.togather.api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.togather.api.dto.request.EnvioMensagemDTO;
import com.togather.api.dto.response.MensagemDTO;
import com.togather.api.entity.Mensagem;
import com.togather.api.repository.MensagemRepository;

@Service
public class MensagemService {
    
    @Autowired
    private MensagemRepository mensagemRepository;

    @Autowired
    private UsuarioService usuarioService;

    public List<MensagemDTO> todas() {
        return mensagemRepository.findByOrderByDataEnvioDesc().stream().map(MensagemDTO::new).collect(Collectors.toList());
    }

    public MensagemDTO enviar(EnvioMensagemDTO envioDto) {
        Mensagem mensagem = new Mensagem();
        mensagem.setAutor(usuarioService.findByLogin(envioDto.getLoginUsuario()));
        mensagem.setConteudo(envioDto.getConteudo());
        mensagem.setTipo(envioDto.getTipo());
        mensagem.setDataEnvio(LocalDateTime.now());

        return new MensagemDTO(mensagemRepository.save(mensagem));
    }
}
