package com.example.DesafioJunior.repository;

import com.example.DesafioJunior.entity.Documentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documentos,Long> {
}
