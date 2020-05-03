package com.ebbers.capslog.infrastructure.persistence;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.connectionfactory.init.CompositeDatabasePopulator;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories
public class R2DBCConfig extends AbstractR2dbcConfiguration {

    @Value("${spring.r2dbc.url}")
    private String url;

    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(url);
    }

    @Bean
    public ConnectionFactoryInitializer initializer(ConnectionFactory cf) {
        ConnectionFactoryInitializer cfi = new ConnectionFactoryInitializer();
        CompositeDatabasePopulator cdp = new CompositeDatabasePopulator();
        cdp.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        cfi.setConnectionFactory(cf);
        cfi.setDatabasePopulator(cdp);
        return cfi;
    }
}
