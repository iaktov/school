package ru.hogwarts.school.Service;


import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Service
public class StudentService {

    private final HashMap<Long, Student> students = new HashMap<>();
    private long lastId = 0;

    public Student createStudents(Student student) {
        student.setId(++lastId);
        students.put(student.getId(),student);
        return student;
    }

    public Student findStudent(long id) {
        return students.get(id);
    }

    public Collection<Student> findStudentByAge(int age) {
        Collection<Student>  result = new ArrayList<>();
        for (Student student:students.values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }

    public Student editStudent(long id,Student student) {
        if (!students.containsKey(id)) {
            return null;
        }
        students.put(id, student);
        return student;
    }

    public Student deleteStudent(long id) {
        return students.remove(id);
    }

}
