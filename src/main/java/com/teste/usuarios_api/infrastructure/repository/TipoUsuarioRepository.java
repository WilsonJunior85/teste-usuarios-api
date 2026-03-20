package com.teste.usuarios_api.infrastructure.repository;

import com.teste.usuarios_api.domain.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {

    Optional<TipoUsuario> findByOrigem(String origem);
}
