package ru.hogwarts.school.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Faculty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


@Service
public class FacultyService {

    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    private long lastId = 0;

    public Faculty createStudents(Faculty faculty) {
        faculty.setId(++lastId);
        faculties.put(lastId,faculty);
        return faculty;
    }

    public Collection<Faculty> findFacultyByColor(String color) {
        Collection<Faculty>  newFaculty = new ArrayList<>();
        for (Faculty faculty:faculties.values()) {
            if (faculty.getColor().equals(color)) {
                newFaculty.add(faculty);
            }
        }
        return newFaculty;
    }

    public Faculty findStudent(Long id) {
        return faculties.get(id);
    }

    public Faculty editStudent(Faculty faculty) {
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteStudent(Long id) {
        return faculties.remove(id);
    }
}
