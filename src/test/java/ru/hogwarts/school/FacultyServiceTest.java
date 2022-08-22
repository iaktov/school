package ru.hogwarts.school;

import org.junit.jupiter.api.Test;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Service.FacultyService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FacultyServiceTest {

    private final FacultyService actual = new FacultyService();

    Faculty firstParams = new Faculty(1L, "Slytherin", "green");
    Faculty secondParams = new Faculty(2L, "Gryffindor", "red");
    Faculty thirdParams = new Faculty(2L, "Gryffindor", "purple");



    @Test
    public void addFacultyTest() {
        assertThat(actual.createFaculty(firstParams).equals(firstParams));
    }

    @Test
    public void findFacultyByColorTest() {
        actual.createFaculty(firstParams);
        actual.createFaculty(secondParams);
        assertThat(actual.findFacultyByColor("red").equals(secondParams));
    }

    @Test
    public void findFacultyByIdTest() {
        actual.createFaculty(firstParams);
        actual.createFaculty(secondParams);
        assertThat(actual.findFaculty(2L).equals(secondParams));
    }

    @Test
    public void editFacultyTest() {
        actual.createFaculty(firstParams);
        actual.createFaculty(secondParams);
        assertThat(actual.editFaculty(2L, thirdParams).equals(thirdParams));
    }

    @Test
    public void deleteFacultyTest() {
        actual.createFaculty(firstParams);
        actual.deleteStudent(1L);
        assertThat(actual.equals(null));
    }

    @Test
    public void editFacultyFailedTest() {
        actual.createFaculty(firstParams);
        actual.createFaculty(secondParams);
        assertNull(actual.editFaculty(3L, thirdParams));
    }


}
