package ru.hogwarts.school.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/port")
public class InfoController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/getPort")
    public String getPort() {
        return serverPort;
    }


}
