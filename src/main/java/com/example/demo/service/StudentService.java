package com.example.demo.service;

import com.example.demo.entity.StudentEntity;
import java.util.List;

public interface StudentService {
    StudentEntity postData(StudentEntity stu);
    List<StudentEntity> getAllData();
    StudentEntity getData(int id);
    StudentEntity updateData(int id, StudentEntity entity);
    String deleteData(int id);
}
