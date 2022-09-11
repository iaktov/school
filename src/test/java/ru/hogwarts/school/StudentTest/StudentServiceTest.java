package ru.hogwarts.school.StudentTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Service.StudentService;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void addStudentTest() {
        Student testStudent = new Student();
        testStudent.setName("StudentName");
        testStudent.setAge(23);
        testStudent.setId(1L);
        when(studentRepository.save(testStudent)).thenReturn(testStudent);
        assertThat(studentRepository.save(testStudent)).isEqualTo(studentService.createStudents(testStudent));
    }

    @Test
    public void findStudentByIdTest() {
        Student testStudent = new Student();
        testStudent.setName("StudentName");
        testStudent.setAge(20);
        testStudent.setId(1L);

        Student secondStudent = new Student();
        testStudent.setName("StudentName2");
        testStudent.setAge(23);
        testStudent.setId(2L);
        studentService.createStudents(testStudent);
        studentService.createStudents(secondStudent);

        when(studentRepository.findById(2L)).thenReturn(Optional.of(secondStudent));
        assertThat(studentRepository.findById(2L)).contains(studentService.findStudent(2L));

    }

    @Test
    public void findStudentByAgeTest() {
        Student testStudent = new Student();
        testStudent.setName("StudentName");
        testStudent.setAge(20);
        testStudent.setId(1L);

        Student secondStudent = new Student();
        testStudent.setName("StudentName2");
        testStudent.setAge(23);
        testStudent.setId(2L);
        studentService.createStudents(testStudent);
        studentService.createStudents(secondStudent);

        when(studentRepository.findByAge(23)).thenReturn(Collections.singletonList(secondStudent));
        assertThat(studentRepository.findByAge(23)).isEqualTo(studentService.findStudentByAge(23));

    }

    @Test
    public void editStudentTest() {
        Student testStudent = new Student();
        testStudent.setName("StudentName");
        testStudent.setAge(23);
        testStudent.setId(2L);

        studentService.createStudents(testStudent);
        testStudent.setName("new faculty");

        when(studentRepository.save(testStudent)).thenReturn(testStudent);
        assertThat(studentRepository.save(testStudent)).isEqualTo(studentService.editStudent(testStudent));
    }

    @Test
    public void deleteStudentTest() {
        Student testStudent = new Student();
        testStudent.setName("StudentName");
        testStudent.setAge(20);
        testStudent.setId(1L);

        Student secondStudent = new Student();
        testStudent.setName("StudentName2");
        testStudent.setAge(23);
        testStudent.setId(2L);

        studentService.createStudents(testStudent);
        studentService.createStudents(secondStudent);
        studentService.deleteStudent(1L);
        assertThat(studentService).isNotNull();
    }



}
