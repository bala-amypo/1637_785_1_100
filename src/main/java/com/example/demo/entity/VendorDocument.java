package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class VendorDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private DocumentType documentType;

    private String fileUrl;

    private LocalDateTime uploadedAt;

    private LocalDate expiryDate;

    private boolean isValid;

    @PrePersist
    public void onUpload() {
        uploadedAt = LocalDateTime.now();
        isValid = (expiryDate == null || expiryDate.isAfter(LocalDate.now()));
    }

}
