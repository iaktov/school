package ru.hogwarts.school.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.Interface.StudentsGetCount;
import ru.hogwarts.school.Interface.StudentsGetAverageAge;
import ru.hogwarts.school.Interface.StudentsGetLastFive;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudents(Student student) {
        logger.info("Was invoked method for create student");
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        logger.warn("Was invoked method for find student by id");
        return studentRepository.findById(id).orElseThrow();
    }

    public StudentsGetCount getStudentsCount() {
        logger.info("Was invoked method for get student count");
        return studentRepository.getStudentsCount();
    }

    public StudentsGetAverageAge getStudentsAverageAge() {
        logger.info("Was invoked method for get average age student");
        return studentRepository.getStudentsAverageAge();
    }

    public List<StudentsGetLastFive> getStudentsByIdLastFive(){
        logger.info("Was invoked method for get last five student by id");
        return studentRepository.getStudentsByIdLastFive();
    }


    public Collection<Student> findStudentByAge(int age) {
        logger.info("Was invoked method for find student by age");
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findStudentByAgeBetweenYears(int min, int max) {
        logger.info("Was invoked method for find student between ages");
        return studentRepository.findByAgeBetween(min, max);
    }


    public Student editStudent(Student student) {
        logger.info("Was invoked method for edit student");
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.warn("Was invoked method for delete student by id");
        studentRepository.deleteById(id);
    }

    public List<String> getStudentsName() {
        logger.info("Was invoked method for get students name that start with letter a");
        return studentRepository.findAll()
                .stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .filter(s -> s.charAt(0) == 'A')
                .sorted()
                .collect(Collectors.toList());
    }

    public OptionalDouble getStudentsAverageAgeByStream() {
        logger.info("Was invoked method for get average age student by stream");
        return studentRepository.findAll()
                .stream()
                .map(Student::getAge)
                .mapToInt(value -> value)
                .average();
    }
}
