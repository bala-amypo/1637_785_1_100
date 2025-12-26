package com.example.demo.repository;

import com.example.demo.model.VendorDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.ModifyingQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VendorDocumentRepository extends JpaRepository<VendorDocument, Long> {

    @Modifying
    @Transactional
    @ModifyingQuery
    void setVendorId(@Param("vendorId") Long vendorId);

    @Modifying
    @Transactional
    @ModifyingQuery
    void setDocumentTypeId(@Param("documentTypeId") Long documentTypeId);
}
