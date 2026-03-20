package com.teste.usuarios_api.infrastructure.repository;

import com.teste.usuarios_api.application.dto.UsuarioProcedureDTO;
import com.teste.usuarios_api.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByOrigem(String origem);

    @Query(value = "EXEC dbo.SP_BUSCAR_USUARIOS_POR_ORIGEM @ORIGEM = :origem", nativeQuery = true)
    List<UsuarioProcedureDTO> buscarUsuariosPorOrigemProcedure(String origem);
}
