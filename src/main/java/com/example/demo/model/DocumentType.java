package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.example.demo.model.Vendor;
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

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
    
    @ManyToMany(mappedBy = "supportedDocumentTypes")
    private Set<Vendor> vendors = new HashSet<>();
    
    // Fix hashCode() to avoid infinite recursion
    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, weight, required, expirationPeriodMonths);
        // DON'T include 'vendors' in hashCode() to avoid circular reference!
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentType that = (DocumentType) o;
        return Double.compare(weight, that.weight) == 0 &&
               required == that.required &&
               expirationPeriodMonths == that.expirationPeriodMonths &&
               Objects.equals(id, that.id) &&
               Objects.equals(name, that.name) &&
               Objects.equals(description, that.description);
        // DON'T compare 'vendors' in equals() either!
    }
public void addVendor(Vendor vendor) {
    this.vendors.add(vendor);
    vendor.getSupportedDocumentTypes().add(this);
}

  
}
