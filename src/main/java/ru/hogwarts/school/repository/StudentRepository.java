package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.Interface.StudentsGetCount;
import ru.hogwarts.school.Interface.StudentsGetAverageAge;
import ru.hogwarts.school.Interface.StudentsGetLastFive;
import ru.hogwarts.school.Model.Student;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findByAge(int age);

    Collection<Student> findByAgeBetween(int min, int max);

    @Query(value = "SELECT count (name) as count FROM student", nativeQuery = true)
    List<StudentsGetCount> getStudentsCount();

    @Query(value = "SELECT avg (age) as avg FROM student", nativeQuery = true)
    List<StudentsGetAverageAge> getStudentsAverageAge();

    @Query(value = "SELECT * from student order by id desc limit 5", nativeQuery = true)
    List<StudentsGetLastFive> getStudentsByIdLastFive();


}
