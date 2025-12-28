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

    @ManyToMany(mappedBy = "supportedDocumentTypes")
    private List<Vendor> vendors = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
public void addVendor(Vendor vendor) {
    this.vendors.add(vendor);
    vendor.getSupportedDocumentTypes().add(this);
}

  
}
