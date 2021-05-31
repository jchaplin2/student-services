package com.in28minutes.springboot;

import com.in28minutes.springboot.config.H2JpaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StudentServicesApplication.class, H2JpaConfig.class})
@TestPropertySource("classpath:application-it.properties")
public class H2IntegrationTest {


    @Test
    public void contextLoads() {

    }
}
