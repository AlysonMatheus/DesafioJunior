package com.example.DesafioJunior.entidades;

import jakarta.persistence.*;


import java.time.LocalDate;

import java.util.ArrayList;

import java.util.List;

@Entity
public class Beneficiario extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Documentos> documentos = new ArrayList<>();

    public Beneficiario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public  LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento( LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Documentos> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documentos> documentos) {
        this.documentos = documentos;
    }
}
