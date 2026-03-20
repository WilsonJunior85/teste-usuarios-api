package com.teste.usuarios_api.application.dto;

import java.time.LocalDate;

public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String matricula;
    private LocalDate dataNascimento;
    private String email;
    private String origem;
    private String tipo;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(Long id, String nome, String matricula, LocalDate dataNascimento,
            String email, String origem, String tipo) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.origem = origem;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
