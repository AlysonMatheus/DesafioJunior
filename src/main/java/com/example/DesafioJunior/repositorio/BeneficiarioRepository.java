package com.example.DesafioJunior.repositorio;

import com.example.DesafioJunior.entidades.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiarioRepository  extends JpaRepository<Beneficiario, Long> {
}
