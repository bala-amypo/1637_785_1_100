package com.example.demo.service.impl;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentEntity postData(StudentEntity stu) {
        return studentRepository.save(stu);
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
