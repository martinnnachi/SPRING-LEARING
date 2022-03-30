package com.martinnnachi.springdemo.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

import static com.martinnnachi.springdemo.ConsoleColours.CYAN_BOLD;
import static com.martinnnachi.springdemo.ConsoleColours.RESET;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.martinnnachi.springdemo")
@PropertySource("classpath:application.properties")
public class DemoAppConfig implements WebMvcConfigurer {

    // set up a variable to hold the properties

    private final Environment env;

    // set up logger for diagnostics
    Logger logger = LoggerFactory.getLogger( getClass().getName() );

    public DemoAppConfig(Environment env) {
        this.env = env;
    }


    // define a bean for the view resolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix( "/WEB-INF/view/" );
        viewResolver.setSuffix( ".jsp" );

        return viewResolver;
    }

    // define a bean for our security datasource
    @Bean
    public DataSource securityDataSource() {

        // create a connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        // set jdbc driver class
        try {
            securityDataSource.setDriverClass( env.getProperty( "spring.datasource.driver-class-name" ) );
        } catch (PropertyVetoException exc) {
            throw new RuntimeException( exc );
        }

        // log the connection properties
        logger.info( CYAN_BOLD + ">>> jdbc.url = " + env.getProperty( "spring.datasource.url" ) + RESET );
        logger.info( CYAN_BOLD + ">>> jdbc.username = " + env.getProperty( "spring.datasource.username" ) + RESET );
        logger.info( CYAN_BOLD + ">>> jdbc.password = " + env.getProperty( "spring.datasource.password" ) + RESET );

        // set database connection properties
        securityDataSource.setJdbcUrl( env.getProperty( "spring.datasource.url" ) );
        securityDataSource.setUser( env.getProperty( "spring.datasource.username" ) );
        securityDataSource.setPassword( env.getProperty( "spring.datasource.password" ) );


        // set connection pool properties
        securityDataSource.setInitialPoolSize( getIntProperty( "connection.pool.initialPoolSize" ) );
        securityDataSource.setMinPoolSize( getIntProperty( "connection.pool.minPoolSize" ) );
        securityDataSource.setMaxPoolSize( getIntProperty( "connection.pool.maxPoolSize" ) );
        securityDataSource.setMaxIdleTime( getIntProperty( "connection.pool.maxIdleTime" ) );


        return securityDataSource;
    }

    // need a helper method
    // read environment property and convert to int
    private int getIntProperty(String propName) {
        String propValue = env.getProperty( propName );

        // convert string to int
        assert propValue != null;
        return Integer.parseInt( propValue );
    }
}
