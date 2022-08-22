package ru.hogwarts.school;

import org.junit.jupiter.api.Test;
import ru.hogwarts.school.Model.Student;
import ru.hogwarts.school.Service.StudentService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StudentServiceTest {

    StudentService actual = new StudentService();

    Student firstParam = new Student(1L, "Harry Potter", 13);
    Student secondParam = new Student(2L, "Ron Wesley", 12);
    Student thirdParam = new Student(2L, "Ron Wesley", 13);

    @Test
    public void createStudentTest() {
        assertThat(actual.createStudents(firstParam).equals(firstParam));
    }

    @Test
    public void editStudentTest() {
        actual.createStudents(firstParam);
        actual.createStudents(secondParam);
        assertThat(actual.editStudent(2L, thirdParam).equals(thirdParam));
    }

    @Test
    public void deleteStudentTest() {
        actual.createStudents(firstParam);
        actual.deleteStudent(1L);
        assertThat(actual.equals(null));
    }

    @Test
    public void editStudentFailedTest() {
        assertNull(actual.editStudent(3L, thirdParam));
    }

    @Test
    public void findStudentByIdTest() {
        actual.createStudents(firstParam);
        actual.createStudents(secondParam);
        assertThat(actual.findStudent(2L).equals(secondParam));
    }

    @Test
    public void findStudentsByAge() {
        actual.createStudents(firstParam);
        actual.createStudents(secondParam);
        assertThat(actual.findStudentByAge(13).equals(firstParam));
    }



}
