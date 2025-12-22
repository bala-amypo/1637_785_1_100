package com.example.demo.controller;

import com.example.demo.entity.VendortEntity;
import com.example.demo.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class VendorController {

    private final VendorService service;

    public StudentController(VendorService service) {
        this.service = service;
    }

    @PostMapping
    public VendorEntity save(@RequestBody VendorEntity stu) {
        return service.postData(stu);
    }

    @GetMapping
    public List<VendorEntity> getAll() {
        return service.getAllData();
    }

    @GetMapping("/{id}")
    public VendorEntity getById(@PathVariable int id) {
        return service.getData(id);
    }

    @PutMapping("/{id}")
    public VendorEntity update(@PathVariable int id, @RequestBody VendorEntity stu) {
        return service.updateData(id, stu);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return service.deleteData(id);
    }
}
