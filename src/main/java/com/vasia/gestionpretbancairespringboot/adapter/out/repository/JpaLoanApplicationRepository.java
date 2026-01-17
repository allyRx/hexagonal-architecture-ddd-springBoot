package com.vasia.gestionpretbancairespringboot.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vasia.gestionpretbancairespringboot.adapter.out.persistence.JpaLoanApplicationEntity;

import java.util.UUID;

public interface JpaLoanApplicationRepository extends JpaRepository<JpaLoanApplicationEntity, UUID> {
}
