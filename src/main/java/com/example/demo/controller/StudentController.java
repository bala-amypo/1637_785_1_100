package com.example.demo.controller;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public StudentEntity save(@RequestBody StudentEntity stu) {
        return service.postData(stu);
    }

    @GetMapping
    public List<StudentEntity> getAll() {
        return service.getAllData();
    }

    @GetMapping("/{id}")
    public StudentEntity getById(@PathVariable int id) {
        return service.getData(id);
    }

    @PutMapping("/{id}")
    public StudentEntity update(@PathVariable int id, @RequestBody StudentEntity stu) {
        return service.updateData(id, stu);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return service.deleteData(id);
    }
}
