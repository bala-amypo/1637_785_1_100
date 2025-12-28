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
@Table(name = "vendors")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)  // Only include fields marked with @EqualsAndHashCode.Include
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include  // Explicitly include this field
    private Long id;

    @EqualsAndHashCode.Include  // Explicitly include this field
    private String vendorName;
    
    @EqualsAndHashCode.Include  // Explicitly include this field
    private String industry;

    @EqualsAndHashCode.Include  // Explicitly include this field
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
        name = "vendor_document_types",
        joinColumns = @JoinColumn(name = "vendor_id"),
        inverseJoinColumns = @JoinColumn(name = "document_type_id")
    )
    private List<DocumentType> supportedDocumentTypes = new ArrayList<>();  // This field is NOT included in equals/hashCode

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}