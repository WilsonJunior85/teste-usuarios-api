package com.teste.usuarios_api.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_USUARIO")
public class TipoUsuario {

    @Id
    @Column(name = "ID_TIPOUSUARIO")
    private Long id;

    @Column(name = "ORIGEM")
    private String origem;

    @Column(name = "DESCR")
    private String descricao;

    public TipoUsuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
