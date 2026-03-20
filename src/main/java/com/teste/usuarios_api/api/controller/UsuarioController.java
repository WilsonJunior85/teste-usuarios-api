
package com.teste.usuarios_api.api.controller;

import com.teste.usuarios_api.application.dto.UsuarioRequestDTO;
import com.teste.usuarios_api.application.dto.UsuarioResponseDTO;
import com.teste.usuarios_api.application.interfaces.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioResponseDTO criarUsuario(@Valid @RequestBody UsuarioRequestDTO dto) {
        return usuarioService.criarUsuario(dto);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @GetMapping
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/entidade/{origem}")
    public List<UsuarioResponseDTO> listarPorEntidade(@PathVariable String origem) {
        return usuarioService.listarPorEntidade(origem);
    }

    @GetMapping("/procedure/{origem}")
    public List<UsuarioResponseDTO> listarPorProcedure(@PathVariable String origem) {
        return usuarioService.listarPorProcedure(origem);
    }
}