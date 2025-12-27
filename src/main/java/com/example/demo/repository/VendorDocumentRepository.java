package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.*;
import com.example.demo.model.*;
public interface VendorDocumentRepository extends JpaRepository<VendorDocument, Long> {
    List<VendorDocument> findByVendor(Vendor vendor);
    List<VendorDocument> findExpiredDocuments(LocalDate date);
}
