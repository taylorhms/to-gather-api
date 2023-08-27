package com.togather.api.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.togather.api.dto.request.AlterarUsuarioDTO;
import com.togather.api.dto.request.NovaContaDTO;
import com.togather.api.dto.response.UsuarioDTO;
import com.togather.api.entity.Usuario;
import com.togather.api.repository.UsuarioRepository;
import com.togather.api.security.TokenService;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder encoder;

    public Usuario findByLogin(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
    }

    public Usuario findById(Long id) throws UsernameNotFoundException {
        return usuarioRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));
    }

    public List<UsuarioDTO> todos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        
        return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }
    
    public UsuarioDTO consultar(Long id) {
        return new UsuarioDTO(findById(id));
    }

    public UsuarioDTO novaConta(NovaContaDTO dados) throws Exception {
        Optional<Usuario> outro = usuarioRepository.findByLogin(dados.getLogin());

        if (outro.isPresent()) {
            throw new Exception("Nome de usuário já em uso");
        }

        Usuario novo = new Usuario();
        novo.setNome(dados.getNome());
        novo.setLogin(dados.getLogin());
        novo.setSenha(encoder.encode(dados.getSenha()));
        novo.setCorPrimaria(corAleatoria());
        novo.setCorSecundaria(corAleatoria());
        usuarioRepository.save(novo);

        return new UsuarioDTO(novo);
    }

    private String corAleatoria() {
        String[] cores = { "red", "orange", "yellow", "lime", "blue", "cyan", "purple", "violet" };
        Random random = new Random();
        return cores[random.nextInt(cores.length)];
    }

    public ResponseEntity<String> alterar(Long id, String token, AlterarUsuarioDTO dados) {
        Usuario alterado = findById(id);
        boolean autorizado = isSameUser(alterado, token);

        if (!autorizado) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Você não tem permissão para alterar este usuário.");
        }

        BeanUtils.copyProperties(dados, alterado);
        usuarioRepository.save(alterado);

        return ResponseEntity.ok("Salvo com sucesso.");
    }

    public ResponseEntity<String> apagar(Long id, String token) {
        Usuario apagado = findById(id);
        boolean autorizado = isSameUser(apagado, token);

        if (!autorizado) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Você não tem permissão para excluir esta conta.");
        }

        usuarioRepository.deleteById(id);

        return ResponseEntity.ok("Excluído com sucesso.");
    }

    /**
     * Verifica se o usuário logado e o que está sendo alterado são o mesmo.
     * Usado para impedir alterações de terceiros.
     * 
     * @param alvo   Usuário sendo modificado
     * @param token  Token para identificar o usuário logado
     * @return       {@code true} se os usuários são iguais, senão {@code false} 
     */
    public boolean isSameUser(Usuario alvo, String token) {
        token = token.replace("Bearer ", "");
        String loginUsuarioLogado = tokenService.getSubject(token);
        return loginUsuarioLogado.equals(alvo.getLogin());
    }

    public ResponseEntity<String> alterarFotoDePerfil(Long id, String token, MultipartFile foto) throws IOException {
        Usuario usuario = findById(id);
        boolean autorizado = isSameUser(usuario, token);

        if (!autorizado) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Você não tem permissão para alterar estes dados.");
        }

        usuario.setFoto(foto.getBytes());
        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Salvo com sucesso.");
    }
}
