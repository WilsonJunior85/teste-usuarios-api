package com.teste.usuarios_api.application.interfaces;

import com.teste.usuarios_api.application.dto.UsuarioRequestDTO;
import com.teste.usuarios_api.application.dto.UsuarioResponseDTO;
import java.util.List;

public interface UsuarioService {

    UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto);

    UsuarioResponseDTO buscarPorId(Long id);

    List<UsuarioResponseDTO> listarTodos();

    List<UsuarioResponseDTO> listarPorEntidade(String origem);

    List<UsuarioResponseDTO> listarPorProcedure(String origem);
}
