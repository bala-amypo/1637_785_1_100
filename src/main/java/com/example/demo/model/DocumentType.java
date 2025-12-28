package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "document_types")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)  // Only include fields marked with @EqualsAndHashCode.Include
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include  // Explicitly include this field
    private Long id;

    @EqualsAndHashCode.Include  // Explicitly include this field
    private int weight;
    
    @EqualsAndHashCode.Include  // Explicitly include this field
    private Boolean required;

    @EqualsAndHashCode.Include  // Explicitly include this field
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "supportedDocumentTypes")
    private List<Vendor> vendors = new ArrayList<>();  // This field is NOT included in equals/hashCode

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
    
    public void addVendor(Vendor vendor) {
        this.vendors.add(vendor);
        vendor.getSupportedDocumentTypes().add(this);
    }
}