package com.netmoor.beseller;

import com.netmoor.beseller.config.PostgresqlContainer;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(value = "test")
class SellerApplicationTests {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = PostgresqlContainer.getInstance();

    @Test
    void contextLoads() {
    }

}
