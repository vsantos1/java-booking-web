package br.com.vs1.imobiliaria.web.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.vs1.imobiliaria.core.models.Usuario;
import br.com.vs1.imobiliaria.core.repositories.UsuarioRepository;
import br.com.vs1.imobiliaria.web.dtos.UsuarioDTO;

@Service
public class WebUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper mapper;

    public WebUsuarioService(UsuarioRepository usuarioRepository, ModelMapper mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    public boolean usuarioExistente(UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findByEmailOrCpf(usuarioDTO.getEmail(),
                usuarioDTO.getCpf());
        if (usuarioOptional.isPresent()) {
            return true;
        }
        return false;

    }

    public void salvarUsuario(UsuarioDTO usuarioDTO) {

     
        Usuario usuario = mapper.map(usuarioDTO, Usuario.class);
        usuarioRepository.save(usuario);
    }

}
