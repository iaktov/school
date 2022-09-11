package ru.hogwarts.school.StudentTest;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import ru.hogwarts.school.Controller.StudentController;
import ru.hogwarts.school.Model.Student;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }


    @Test
    void testPostPutGetDeleteStudent() throws Exception {
        Student student = new Student();
        student.setName("sdfsdf");
        student.setAge(23);


        Student secondStudent = new Student();
        secondStudent.setName("ASDASF");
        secondStudent.setAge(574);

        Assertions
                .assertThat(this.restTemplate.postForEntity("http://localhost:" + port + "/student", student, String.class))
                .isNotNull();
        this.restTemplate.put("http://localhost:" + port + "/student", secondStudent, String.class);

        assertNotNull(this.restTemplate.getForObject("http://localhost:" + port + "/student", String.class));
        this.restTemplate.delete("http://localhost:" + port + "/student", secondStudent, String.class);
        assertNotNull(this.restTemplate.getForObject("http://localhost:" + port + "/student", String.class));
    }

    @Test
    void TestExceptions() throws Exception {
        Student student = new Student();
        Assertions
                .assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student", student, String.class));
    }


}
