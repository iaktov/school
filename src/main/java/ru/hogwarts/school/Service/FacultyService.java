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

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        faculties.put(faculty.getId(),faculty);
        return faculty;
    }

    public Collection<Faculty> findFacultyByColor(String color) {
        Collection<Faculty>  result = new ArrayList<>();
        for (Faculty faculty:faculties.values()) {
            if (faculty.getColor().equals(color)) {
                result.add(faculty);
            }
        }
        return result;
    }

    public Faculty findFaculty(long id) {
        return faculties.get(id);
    }

    public Faculty editFaculty(long id, Faculty faculty) {
        if (!faculties.containsKey(id)) {
            return null;
        }
        faculties.put(id, faculty);
        return faculty;
    }

    public Faculty deleteStudent(long id) {
        return faculties.remove(id);
    }
}
