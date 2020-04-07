package com.lighthms.lighthmsservice;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;

@Transactional
@SpringBootTest
@ActiveProfiles("integration-test") // Sets active profile as classpath:/bootstrap-integration-test.properties
@ContextConfiguration(initializers = {AbstractIntegrationTest.Initializer.class})
public abstract class AbstractIntegrationTest {

    private static PostgreSQLContainer sqlContainer;

    /**
     * Initialize PostgreSQL container
     */
    static {
        sqlContainer = new PostgreSQLContainer("postgres:10.7")
                .withDatabaseName("integration-tests-db")
                .withUsername("sa")
                .withPassword("sa");

        sqlContainer.start(); // Start
    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        /**
         * Set test property values from {@link PostgreSQLContainer} .
         *
         * @param configurableApplicationContext
         */
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + sqlContainer.getJdbcUrl(),
                    "spring.datasource.username=" + sqlContainer.getUsername(),
                    "spring.datasource.password=" + sqlContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

}
