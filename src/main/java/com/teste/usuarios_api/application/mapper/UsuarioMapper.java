package com.teste.usuarios_api.application.mapper;

import com.teste.usuarios_api.application.dto.UsuarioRequestDTO;
import com.teste.usuarios_api.application.dto.UsuarioResponseDTO;
import com.teste.usuarios_api.domain.model.TipoUsuario;
import com.teste.usuarios_api.domain.model.Usuario;

public class UsuarioMapper {

    private UsuarioMapper() {
    }

    public static Usuario toEntity(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNome(dto.getNome());
        usuario.setMatricula(dto.getMatricula());
        usuario.setDataNascimento(dto.getDataNascimento());
        usuario.setEmail(dto.getEmail());
        usuario.setOrigem(dto.getOrigem());
        return usuario;
    }

    public static UsuarioResponseDTO toResponseDTO(Usuario usuario, TipoUsuario tipoUsuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setMatricula(usuario.getMatricula());
        dto.setDataNascimento(usuario.getDataNascimento());
        dto.setEmail(usuario.getEmail());
        dto.setOrigem(usuario.getOrigem());
        dto.setTipo(tipoUsuario != null ? tipoUsuario.getDescricao() : null);
        return dto;
    }
}