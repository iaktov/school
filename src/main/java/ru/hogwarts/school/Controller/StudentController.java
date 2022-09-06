package ru.hogwarts.school.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.Model.Faculty;
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
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudents(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    //GET by age or between
    @GetMapping()
    public ResponseEntity<Collection<Student>> getStudentsByAgeOrAgeBetween(@RequestParam(required = false) Integer age,
                                                                            @RequestParam(required = false) Integer min,
                                                                            @RequestParam(required = false) Integer max) {

        if (age != null && age > 0) {
            return ResponseEntity.ok(studentService.findStudentByAge(age));
        }

        if (min != null && min > 0 && max != null && max > 0) {
            return ResponseEntity.ok(studentService.findStudentByAgeBetweenYears(min, max));
        }

        return ResponseEntity.ok(Collections.emptyList());
    }
    //GET student faculty
    @GetMapping("/{id}/faculty")
    public ResponseEntity<Faculty> getStudentsFaculty(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student.getFaculty());
    }


    //POST
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudents(student);
    }

    //PUT
    @PutMapping()
    public ResponseEntity<Student> editStudents(@RequestBody Student student) {
        studentService.editStudent(student);
        return ResponseEntity.ok(student);
    }


    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
