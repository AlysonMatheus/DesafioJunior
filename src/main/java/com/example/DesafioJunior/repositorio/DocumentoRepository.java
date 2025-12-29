package com.example.DesafioJunior.repositorio;

import com.example.DesafioJunior.entidades.Documentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documentos,Long> {
}
