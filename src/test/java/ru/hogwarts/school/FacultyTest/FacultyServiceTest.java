package ru.hogwarts.school.FacultyTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.Service.FacultyService;
import ru.hogwarts.school.repository.FacultyRepository;



import java.util.Collections;

import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FacultyServiceTest {

    @Mock
    private FacultyRepository facultyRepository;

    @InjectMocks
    private FacultyService facultyService;


    @Test
    public void addFacultyTest() {
        Faculty testFaculty = new Faculty();
        testFaculty.setName("Faculty");
        testFaculty.setColor("color");
        testFaculty.setId(1l);
        when(facultyRepository.save(testFaculty)).thenReturn(testFaculty);
        assertThat(facultyRepository.save(testFaculty)).isEqualTo(facultyService.createFaculty(testFaculty));
    }

    @Test
    public void findFacultyByIdTest() {
        Faculty testFaculty = new Faculty();
        testFaculty.setName("Faculty");
        testFaculty.setColor("color");
        testFaculty.setId(1L);

        Faculty secondFaculty = new Faculty();
        testFaculty.setName("Faculty2");
        testFaculty.setColor("white");
        testFaculty.setId(2L);
        facultyService.createFaculty(testFaculty);
        facultyService.createFaculty(secondFaculty);

        when(facultyRepository.findById(2L)).thenReturn(Optional.of(secondFaculty));
        assertThat(Optional.of(facultyService.findFaculty(2L))).isEqualTo(facultyRepository.findById(2L));
    }

    @Test
    public void findFacultyByColorTest() {
        Faculty testFaculty = new Faculty();
        testFaculty.setName("Faculty");
        testFaculty.setColor("color");
        testFaculty.setId(1L);

        Faculty secondFaculty = new Faculty();
        testFaculty.setName("Faculty2");
        testFaculty.setColor("white");
        testFaculty.setId(2L);

        facultyService.createFaculty(testFaculty);
        facultyService.createFaculty(secondFaculty);

        when(facultyRepository.findByColorIgnoreCase("color")).thenReturn(Collections.singletonList(testFaculty));
        assertThat(facultyRepository.findByColorIgnoreCase("color")).isEqualTo(facultyService.findFacultyByColor("color"));
    }


    @Test
    public void editFacultyTest() {
        Faculty testFaculty = new Faculty();
        testFaculty.setName("Faculty");
        testFaculty.setColor("color");
        testFaculty.setId(1L);

        facultyService.createFaculty(testFaculty);
        testFaculty.setName("new faculty");

        when(facultyRepository.save(testFaculty)).thenReturn(testFaculty);
        assertThat(facultyRepository.save(testFaculty)).isEqualTo(facultyService.editFaculty(testFaculty));
    }

    @Test
    public void deleteFacultyTest() {
        Faculty testFaculty = new Faculty();
        testFaculty.setName("Faculty");
        testFaculty.setColor("color");
        testFaculty.setId(1L);

        Faculty secondFaculty = new Faculty();
        testFaculty.setName("Faculty2");
        testFaculty.setColor("white");
        testFaculty.setId(2L);
        facultyService.createFaculty(testFaculty);
        facultyService.createFaculty(secondFaculty);
        facultyService.deleteFaculty(1L);
        assertThat(facultyService).isNotNull();
    }


}
