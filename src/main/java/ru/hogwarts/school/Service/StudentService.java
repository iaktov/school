package ru.hogwarts.school.Service;


import org.springframework.stereotype.Service;
import ru.hogwarts.school.Interface.StudentsGetCount;
import ru.hogwarts.school.Interface.StudentsGetAverageAge;
import ru.hogwarts.school.Interface.StudentsGetLastFive;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudents(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public List<StudentsGetCount> getStudentsCount() {
        return studentRepository.getStudentsCount();
    }

    public List<StudentsGetAverageAge> getStudentsAverageAge() {
        return studentRepository.getStudentsAverageAge();
    }

    public List<StudentsGetLastFive> getStudentsByIdLastFive(){
        return studentRepository.getStudentsByIdLastFive();
    }


    public Collection<Student> findStudentByAge(int age) {
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findStudentByAgeBetweenYears(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }


    public Student editStudent(Student student) {

        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
}
