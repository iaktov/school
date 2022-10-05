package ru.hogwarts.school.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Service.StudentService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudents(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    //GET by age
    @GetMapping()
    public ResponseEntity<Collection<Student>> getStudentsByAge(@RequestParam(required = false) int age) {
        if (age > 0) {
            return ResponseEntity.ok(studentService.findStudentByAge(age));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    //POST
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudents(student);
    }

    //PUT
    @PutMapping("{id}")
    public ResponseEntity<Student> editStudents(@RequestBody Student student) {
        Student findStudent = studentService.editStudent(student);
        if (findStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(student);
    }


    //DELETE
    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
