package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

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
    private Set<Vendor> vendors = new HashSet<>();

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        if (weight <= 0) {
            weight = 1; 
        }
        if (required == null) {
            required = false; 
        }
    }
    
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }
    
    public Boolean getRequired() { return required; }
    public void setRequired(Boolean required) { this.required = required; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public Set<Vendor> getVendors() { return vendors; }
    public void setVendors(Set<Vendor> vendors) { this.vendors = vendors; }
    
    public void addVendor(Vendor vendor) {
        this.vendors.add(vendor);
        vendor.getSupportedDocumentTypes().add(this);
    }
    
   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentType that = (DocumentType) o;
        
       
        if (id != null && that.id != null) {
            return Objects.equals(id, that.id);
        }
        
      
        return super.equals(o);
    }
    
    @Override
    public int hashCode() {
        if (id != null) {
            return Objects.hash(id);
        }
    
        return System.identityHashCode(this);
    }
    
    @Override
    public String toString() {
        return "DocumentType{" +
               "id=" + id +
               ", weight=" + weight +
               ", required=" + required +
               '}';
    }
}