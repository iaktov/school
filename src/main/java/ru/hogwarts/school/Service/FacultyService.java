package ru.hogwarts.school.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.Model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {

    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository)   {
        
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.info("Was invoked method for create faculty");
        return facultyRepository.save(faculty);
    }

    public Collection<Faculty> findFacultyByColor(String color) {
        logger.info("Was invoked method for find faculty by color");
        return facultyRepository.findByColorIgnoreCase(color);
    }

    public Collection<Faculty> findFacultyByName(String name) {
        logger.debug("Was invoked method for find faculty by name");
        return facultyRepository.findByNameIgnoreCase(name);
    }

    public Faculty findFaculty(long id) {
        logger.debug("Was invoked method for find faculty by id");
        return facultyRepository.findById(id).orElseThrow();
    }




    public Faculty editFaculty(Faculty faculty) {
        logger.info("Was invoked method for edit faculty");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        logger.debug("Was invoked method for delete faculty by id");
        facultyRepository.deleteById(id);
    }
}
