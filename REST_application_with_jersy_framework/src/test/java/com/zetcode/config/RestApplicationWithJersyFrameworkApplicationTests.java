package com.zetcode.config;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class RestApplicationWithJersyFrameworkApplicationTests {

	@Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void hello() {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/hello",
                String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isEqualTo("Hello from Spring");
    }

    @Test
    public void reverse() {
        ResponseEntity<String> entity = this.restTemplate
                .getForEntity("/reverse?data=regit", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isEqualTo("tiger");
    }

    @Test
    public void validation() {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/reverse",
                String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}

