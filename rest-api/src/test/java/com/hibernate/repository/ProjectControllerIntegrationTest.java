package com.hibernate.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

//@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@WebMvcTest
public class ProjectControllerIntegrationTest {


    @Test
    public void whenWebEnvIsInstantiated_thenOK() {

    }
}
