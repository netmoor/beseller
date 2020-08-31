package com.netmoor.beseller.config;

import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.PostgreSQLContainer;

/**
 * PostgresqlContainer.
 *
 * @author Nikolay_Batov
 */
@Slf4j
public class PostgresqlContainer extends PostgreSQLContainer<PostgresqlContainer> {

    private static final String IMAGE_VERSION = "postgres:11.1";
    private static PostgresqlContainer container;

    private PostgresqlContainer() {
        super(IMAGE_VERSION);
    }

    public static PostgresqlContainer getInstance() {
        if (container == null) {
            container = new PostgresqlContainer();
        }
        container.start();
        return container;
    }

    @Override
    public void start() {
        super.start();
        log.info("Db_url: {}, Db_userName: {}, Db_password: {}", container.getJdbcUrl(), container.getUsername(), getPassword());
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}
