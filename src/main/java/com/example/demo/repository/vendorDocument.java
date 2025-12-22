package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.DocumentType;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {

    boolean existsByTypeName(String typeName);
}
