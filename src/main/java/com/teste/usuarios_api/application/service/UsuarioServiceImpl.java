package com.teste.usuarios_api.application.service;

import com.teste.usuarios_api.application.dto.UsuarioProcedureDTO;
import com.teste.usuarios_api.application.dto.UsuarioRequestDTO;
import com.teste.usuarios_api.application.dto.UsuarioResponseDTO;
import com.teste.usuarios_api.application.interfaces.UsuarioService;
import com.teste.usuarios_api.application.mapper.UsuarioMapper;
import com.teste.usuarios_api.domain.model.TipoUsuario;
import com.teste.usuarios_api.domain.model.Usuario;
import com.teste.usuarios_api.infrastructure.repository.TipoUsuarioRepository;
import com.teste.usuarios_api.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TipoUsuarioRepository tipoUsuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
            TipoUsuarioRepository tipoUsuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    @Override
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = UsuarioMapper.toEntity(dto);
        Usuario salvo = usuarioRepository.save(usuario);

        TipoUsuario tipoUsuario = tipoUsuarioRepository.findByOrigem(salvo.getOrigem()).orElse(null);

        return UsuarioMapper.toResponseDTO(salvo, tipoUsuario);
    }

    @Override
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        TipoUsuario tipoUsuario = tipoUsuarioRepository.findByOrigem(usuario.getOrigem()).orElse(null);

        return UsuarioMapper.toResponseDTO(usuario, tipoUsuario);
    }

    @Override
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> {
                    TipoUsuario tipoUsuario = tipoUsuarioRepository.findByOrigem(usuario.getOrigem()).orElse(null);
                    return UsuarioMapper.toResponseDTO(usuario, tipoUsuario);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioResponseDTO> listarPorEntidade(String origem) {
        return usuarioRepository.findByOrigem(origem)
                .stream()
                .map(usuario -> {
                    TipoUsuario tipoUsuario = tipoUsuarioRepository.findByOrigem(usuario.getOrigem()).orElse(null);
                    return UsuarioMapper.toResponseDTO(usuario, tipoUsuario);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioResponseDTO> listarPorProcedure(String origem) {
        return usuarioRepository.buscarUsuariosPorOrigemProcedure(origem)
                .stream()
                .map(this::mapProjectionToResponse)
                .collect(Collectors.toList());
    }

    private UsuarioResponseDTO mapProjectionToResponse(UsuarioProcedureDTO projection) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(projection.getId());
        dto.setNome(projection.getNome());
        dto.setEmail(projection.getEmail());
        dto.setTipo(projection.getTipo());
        return dto;
    }
}
