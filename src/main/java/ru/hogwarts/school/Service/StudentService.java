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
        students.put(lastId,student);
        return student;
    }

    public Student findStudent(Long id) {
        return students.get(id);
    }

    public Collection<Student> findStudentByAge(int age) {
        Collection<Student>  newStudents = new ArrayList<>();
        for (Student student:students.values()) {
            if (student.getAge() == age) {
                newStudents.add(student);
            }
        }
        return newStudents;
    }

    public Student editStudent(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(Long id) {
        return students.remove(id);
    }

}
