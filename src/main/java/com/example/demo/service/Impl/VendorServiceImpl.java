package com.example.demo.service.impl;

import com.example.demo.entity.VendorEntity;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository VendorRepository;

    public VendorServiceImpl(VendorRepository VendorRepository) {
        this.VendorRepository = VendorRepository;
    }

    @Override
    public VendorEntity postData(VendorEntity stu) {
        return VendorRepository.save(stu);
    }

    @Override
    public List<VendorEntity> getAllData() {
        return VendorRepository.findAll();
    }

    @Override
    public VendorEntity getData(int id) {
        return VendorRepository.findById(id).orElse(null);
    }

    @Override
    public VendorEntity updateData(int id, VendorEntity entity) {
        if (VendorRepository.existsById(id)) {
            entity.setId(id);
            return VendorRepository.save(entity);
        }
        return null;
    }

    @Override
    public String deleteData(int id) {
        VendorRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
