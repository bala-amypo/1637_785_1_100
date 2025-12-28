package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "document_types")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int weight;
    private Boolean required;

    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "supportedDocumentTypes")
    private List<Vendor> vendors = new ArrayList<>();  // Changed from Set to List

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
    
    public void addVendor(Vendor vendor) {
        this.vendors.add(vendor);
        vendor.getSupportedDocumentTypes().add(this);
    }
    
    // Override equals and hashCode to avoid infinite recursion
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentType that = (DocumentType) o;
        return weight == that.weight &&
               Objects.equals(id, that.id) &&
               Objects.equals(required, that.required) &&
               Objects.equals(createdAt, that.createdAt);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, weight, required, createdAt);
    }
}