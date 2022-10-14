package ru.hogwarts.school.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.Interface.StudentsGetCount;
import ru.hogwarts.school.Interface.StudentsGetAverageAge;
import ru.hogwarts.school.Interface.StudentsGetLastFive;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Service.StudentService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

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

    //GET by age
    @GetMapping()
    public ResponseEntity<Collection<Student>> getStudentsByAgeOrAgeBetween(@RequestParam(required = false) Integer age) {

        if (age != null && age > 0) {
            return ResponseEntity.ok(studentService.findStudentByAge(age));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    //GET age between
    @GetMapping("/ages")
    public ResponseEntity<Collection<Student>> getStudentsByAgeBetween(@RequestParam(required = false) Integer min,
                                                                       @RequestParam(required = false) Integer max) {
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

    //GET students count
    @GetMapping("/count")
    public ResponseEntity<StudentsGetCount> getStudentsCount() {
        return ResponseEntity.ok(studentService.getStudentsCount());
    }

    //GET students avg age
    @GetMapping("/average_age")
    public ResponseEntity<StudentsGetAverageAge> getStudentsAverageAge() {
        return ResponseEntity.ok(studentService.getStudentsAverageAge());
    }

    //GET students last five by id
    @GetMapping("last_five_students_by_id")
    public ResponseEntity<List<StudentsGetLastFive>> getStudentsByIdLastFive() {
        return ResponseEntity.ok(studentService.getStudentsByIdLastFive());
    }

    //GET students name that start with letter a
    @GetMapping("students_name_that_start_with_letter_a")
    public ResponseEntity<List<String>> getStudentsName() {
        return ResponseEntity.ok(studentService.getStudentsName());
    }

    //GET students average age by stream
    @GetMapping("get_average_age_by_stream")
    public ResponseEntity<OptionalDouble> getAverageAgeByStream() {
        return ResponseEntity.ok(studentService.getStudentsAverageAgeByStream());
    }

    //GET first six students name with 2 threads
    @GetMapping("/getNameByFlow")
    public void getName() {
        studentService.getStudentsNameByFlow();
    }
    @GetMapping("/getNameByFlowSynchronize")
    public void getNameSynchronize() {
        studentService.getStudentsNameByFlowSynchronize();
    }




    //POST
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        studentService.createStudents(student);
        return ResponseEntity.ok(student);
    }

    //PUT
    @PutMapping()
    public ResponseEntity<Student> editStudents(@RequestBody Student student) {
        studentService.editStudent(student);
        return ResponseEntity.ok(student);
    }



    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Faculty> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
