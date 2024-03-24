package com.example.ATDev.Controller;

import com.example.ATDev.Service.StudentService;
import com.example.ATDev.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/select/{Id}")
    public ResponseEntity<Student> findById(@PathVariable Long Id){
        Student student=studentService.findById(Id);
        if (student!=null){
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/select")
    public ResponseEntity<List<Student>> findAll(){
        List<Student> ls=studentService.findAll();
        if(ls!=null){
            return new ResponseEntity<>(ls, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/insert")
    public ResponseEntity<String> CreateStudent(@RequestBody Student newStudent){
        Boolean flag=studentService.CreateStudent(newStudent);
        if (flag==true){
            return new ResponseEntity<>("Student Added", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Invalid",HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long Id){
        Boolean flag=studentService.DeleteStudent(Id);
        if (flag==true){
            return new ResponseEntity<>("Student Delted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/put/{Id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long Id,@RequestBody Student newStudent){
        Boolean flag=studentService.UpdateStudent(Id,newStudent);
        if (flag==true){
            return new ResponseEntity<>("Student Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid",HttpStatus.NOT_FOUND);
    }
}
