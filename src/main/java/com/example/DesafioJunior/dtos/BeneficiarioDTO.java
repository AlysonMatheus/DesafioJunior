package com.example.DesafioJunior.dtos;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;

public record BeneficiarioDTO(Long id, String nome, String telefone, LocalDate dataNascimento,
                              LocalDateTime dataInclusao, LocalDateTime dataAtualizacao,
                              List<DocumentosDTO> documentos) {
}
