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
        this.studentRepository = studentRepository;
    }

    @Override
    public VendorEntity postData(VendorEntity stu) {
        return vendorRepository.save(stu);
    }

    @Override
    public List<StudentEntity> getAllData() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity getData(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public StudentEntity updateData(int id, StudentEntity entity) {
        if (studentRepository.existsById(id)) {
            entity.setId(id);
            return studentRepository.save(entity);
        }
        return null;
    }

    @Override
    public String deleteData(int id) {
        studentRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
