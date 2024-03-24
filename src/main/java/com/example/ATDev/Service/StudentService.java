package com.example.ATDev.Service;

import com.example.ATDev.model.Student;

import java.util.List;

public interface  StudentService {
    Boolean CreateStudent(Student student);
    List<Student> findAll();
    Boolean UpdateStudent(Long Id,Student updatedStudent);
    Boolean DeleteStudent(Long Id);
    Student findById(Long Id);
}
