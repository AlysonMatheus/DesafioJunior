package com.example.DesafioJunior.services;


import com.example.DesafioJunior.dtos.BeneficiarioDTO;
import com.example.DesafioJunior.dtos.BeneficiarioRequest;
import com.example.DesafioJunior.dtos.DocumentosDTO;
import com.example.DesafioJunior.entity.Beneficiario;
import com.example.DesafioJunior.entity.Documentos;
import com.example.DesafioJunior.repository.BeneficiarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;


@Service
public class BeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;



    @Autowired
    public BeneficiarioService(BeneficiarioRepository beneficiarioRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
       ;
    }

    @Transactional
    public BeneficiarioDTO adicionar(BeneficiarioDTO beneficiarioDTO, DocumentosDTO documentosDTO) {
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setNome(beneficiarioDTO.nome());
        beneficiario.setTelefone(beneficiarioDTO.telefone());
        beneficiario.setDataNascimento(beneficiarioDTO.dataNascimento());
        beneficiario.setDataInclusao(LocalDateTime.now());
        beneficiario.setDataAtualizacao(LocalDateTime.now());

        Documentos documentos = new Documentos();
        documentos.setTipoDocumento(documentosDTO.tipoDocumento());
        documentos.setNumero(documentosDTO.numero());

        documentos.setBeneficiario(beneficiario);


        beneficiario.getDocumentos().add(documentos);

        Beneficiario salvo = beneficiarioRepository.save(beneficiario);


        return new BeneficiarioDTO(
                salvo.getId(),
                salvo.getNome(),
                salvo.getTelefone(),
                salvo.getDataNascimento(),
                salvo.getDataInclusao(),
                salvo.getDataAtualizacao(),
                salvo.getDocumentos().stream()
                        .map(doc -> new DocumentosDTO(doc.getTipoDocumento(), doc.getNumero()))
                        .toList());
    }

    public List<BeneficiarioDTO> listar() {
        List<Beneficiario> beneficiarios = beneficiarioRepository.findAll();

        return beneficiarios.stream()
                .distinct()
                .map(b -> new BeneficiarioDTO(
                        b.getId(),
                        b.getNome(),
                        b.getTelefone(),
                        b.getDataNascimento(),
                        b.getDataInclusao(),
                        b.getDataAtualizacao(),
                        b.getDocumentos().stream()
                                .map(doc -> new DocumentosDTO(doc.getTipoDocumento(), doc.getNumero()))
                                .toList()
                )).toList();
    }

    public List<DocumentosDTO> listarDocumentos(Long id) {
        Beneficiario listar = beneficiarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario com o id: " + id + " nao encontrado"));
        return listar.getDocumentos().stream().map(tudo -> new DocumentosDTO(tudo.getTipoDocumento(), tudo.getNumero())).toList();
    }


    @Transactional
    public BeneficiarioDTO atualizar(Long id, BeneficiarioRequest request) {


        Beneficiario a = beneficiarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));


        a.setNome(request.beneficiario().nome());
        a.setTelefone(request.beneficiario().telefone());
        a.setDataAtualizacao(LocalDateTime.now());


        Beneficiario atualizado = beneficiarioRepository.save(a);


        return new BeneficiarioDTO(
                atualizado.getId(),
                atualizado.getNome(),
                atualizado.getTelefone(),
                atualizado.getDataNascimento(),
                atualizado.getDataInclusao(),
                atualizado.getDataAtualizacao(),
                atualizado.getDocumentos().stream()
                        .map(doc -> new DocumentosDTO(doc.getTipoDocumento(), doc.getNumero()))
                        .toList()
        );
    }

    public void remover(Long id) {
        Beneficiario a = beneficiarioRepository.findById(id).orElseThrow(() -> new RuntimeException(" Usuario nao encontrado"));

        beneficiarioRepository.delete(a);
    }


}
