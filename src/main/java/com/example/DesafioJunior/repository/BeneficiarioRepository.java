package com.example.DesafioJunior.repository;

import com.example.DesafioJunior.entity.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiarioRepository  extends JpaRepository<Beneficiario, Long> {
}
