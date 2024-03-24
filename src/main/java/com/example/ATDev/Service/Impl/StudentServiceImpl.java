package com.example.ATDev.Service.Impl;

import com.example.ATDev.Service.StudentService;
import com.example.ATDev.model.Student;
import com.example.ATDev.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public Boolean CreateStudent(Student student) {
        Student s=studentRepo.save(student);
        if(s!=null){
            return true;
        }
        return false;
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Boolean UpdateStudent(Long Id,Student updatedStudent) {
        Student s=studentRepo.findById(Id).orElse(null);
        if(s!=null){
            s.setName(updatedStudent.getName());
            s.setRollno(updatedStudent.getRollno());
            s.setClassroom(updatedStudent.getClassroom());
            s.setAddress(updatedStudent.getAddress());
            studentRepo.save(s);

            return true;
        }
        return false;
    }

    @Override
    public Boolean DeleteStudent(Long Id) {
        Student s=studentRepo.findById(Id).orElse(null);
        if(s!=null){
            studentRepo.deleteById(Id);
            return true;
        }
        return false;
    }

    @Override
    public Student findById(Long Id) {
        return studentRepo.findById(Id).orElse(null);
    }
}
