package com.example.demo.repository;

import com.example.demo.model.VendorDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VendorDocumentRepository extends JpaRepository<VendorDocument, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE VendorDocument v SET v.vendor.id = :vendorId WHERE v.id = :id")
    void setVendorId(@Param("vendorId") Long vendorId, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE VendorDocument v SET v.documentTypeId = :documentTypeId WHERE v.id = :id")
    void setDocumentTypeId(@Param("documentTypeId") Long documentTypeId, @Param("id") Long id);
}
