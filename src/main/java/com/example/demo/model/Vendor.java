package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vendorName;
    private String industry;

    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
        name = "vendor_document_types",
        joinColumns = @JoinColumn(name = "vendor_id"),
        inverseJoinColumns = @JoinColumn(name = "document_type_id")
    )
    private List<DocumentType> supportedDocumentTypes = new ArrayList<>();  // Changed from Set to List

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
    
    // Override equals and hashCode to avoid infinite recursion
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendor vendor = (Vendor) o;
        return Objects.equals(id, vendor.id) &&
               Objects.equals(vendorName, vendor.vendorName) &&
               Objects.equals(industry, vendor.industry) &&
               Objects.equals(createdAt, vendor.createdAt);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, vendorName, industry, createdAt);
    }
}