package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.VendorEntity;

public interface VendorRepository extends JpaRepository<VendorEntity, Integer> {
}
