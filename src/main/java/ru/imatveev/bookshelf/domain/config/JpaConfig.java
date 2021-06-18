package ru.imatveev.bookshelf.domain.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("ru.imatveev.bookshelf.domain.repository")
public class JpaConfig {
}
