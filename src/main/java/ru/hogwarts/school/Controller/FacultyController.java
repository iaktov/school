package ru.hogwarts.school.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Service.FacultyService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    //GET
    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    //GET by color
    @GetMapping()
    public ResponseEntity<Collection<Faculty>> getFacultyByColor(String color) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findFacultyByColor(color));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

    //POST
    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    //PUT
    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Long id,@RequestBody Faculty faculty) {
        Faculty findFaculty = facultyService.editFaculty(id, faculty);
        if (findFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(faculty);
    }


    //DELETE
    @DeleteMapping("{id}")
    public Faculty deleteFaculty(@PathVariable Long id) {
        return facultyService.deleteStudent(id);
    }
}
