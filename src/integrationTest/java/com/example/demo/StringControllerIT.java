package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StringControllerIT {

    @LocalServerPort
    private int port;

    @MockBean
    private StringProducer stringProducer;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        when(stringProducer.getNumberOfStrings(anyInt())).thenReturn(List.of("foo"));
    }

    @Test
    public void fooTest() {
        String url = String.format("http://localhost:%d/strings", this.port);
        ResponseDto response = restTemplate.getForObject(url, ResponseDto.class);
        assertNotNull(response);
        assertEquals(1, response.detail().size());
    }
}
