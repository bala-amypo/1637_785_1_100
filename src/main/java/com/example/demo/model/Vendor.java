package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.example.demo.model.DocumentType;
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
    private Set<DocumentType> supportedDocumentTypes = new HashSet<>();

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
public void addDocumentType(DocumentType documentType) {
    this.supportedDocumentTypes.add(documentType);
    documentType.getVendors().add(this);
}

@ManyToMany
    private Set<DocumentType> supportedDocumentTypes = new HashSet<>();
    
    // Or if it's a List
    @ManyToMany
    private List<DocumentType> supportedDocumentTypes = new ArrayList<>();
    
    public Set<DocumentType> getSupportedDocumentTypes() {
        return supportedDocumentTypes;
    }
}
