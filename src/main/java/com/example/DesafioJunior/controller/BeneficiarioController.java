package com.example.DesafioJunior.controller;

import com.example.DesafioJunior.DTOs.BeneficiarioDTO;
import com.example.DesafioJunior.DTOs.BeneficiarioRequest;

import com.example.DesafioJunior.DTOs.DocumentosDTO;
import com.example.DesafioJunior.entidades.Beneficiario;

import com.example.DesafioJunior.services.BeneficiarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {
    @Autowired
    private BeneficiarioService beneficiarioService;

    @Operation(summary = "Cria um novo beneficiário e seus documentos")
    @PostMapping
    public ResponseEntity<BeneficiarioDTO> criar(@RequestBody BeneficiarioRequest request) {
        BeneficiarioDTO salvo = beneficiarioService.adicionar(request.beneficiario(), request.documentos());  
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);


    }

    @Operation(summary = "Retorna a lista de todos os beneficiários cadastrados.")
    @GetMapping
    public ResponseEntity<List<BeneficiarioDTO>> listar() {
        List<BeneficiarioDTO> lista = beneficiarioService.listar();
        return ResponseEntity.ok(lista);
    }

    @Operation(summary = "Retorna apenas a lista de documentos de um beneficiário")
    @GetMapping("/{id}/documentos")
    public List<DocumentosDTO> listarPorDocumento(@PathVariable Long id) {

        return beneficiarioService.listarDocumentos(id);
    }

    @Operation(summary = "Atualiza os dados de um beneficiário existente")
    @PutMapping("/{id}")
    public ResponseEntity<BeneficiarioDTO> atualizar(@PathVariable Long id, @RequestBody BeneficiarioRequest request) {
        BeneficiarioDTO atualizado = beneficiarioService.atualizar(id, request);
        return ResponseEntity.ok(atualizado);

    }

    @Operation(summary = "Exclui um beneficiário do sistema.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        beneficiarioService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
