package com.spring.dbstarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


/**
 * Let's build a simple starter that will create another CommandLineRunner that will take the collection,
 * of all the Repository instances and print out the count of the total entries for each
 */
@Configuration
public class DbCountAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public DbCountRunner dbCountRunner(Collection<CrudRepository> repositories) {
        return new DbCountRunner(repositories);
    }
}
