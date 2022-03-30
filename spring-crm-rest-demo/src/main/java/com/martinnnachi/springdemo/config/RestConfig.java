package com.martinnnachi.springdemo.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

import static com.martinnnachi.springdemo.ConsoleColours.*;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.martinnnachi.springdemo")
@PropertySource("classpath:application.properties")
public class RestConfig implements WebMvcConfigurer {

    // set up a variable to hold the properties

    private final Environment env;

    // set up logger for diagnostics
    Logger logger = LoggerFactory.getLogger( getClass().getName() );

    public RestConfig(Environment env) {
        this.env = env;
    }

    // define a bean for the view resolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix( "/WEB-INF/" );
        viewResolver.setSuffix( ".jsp" );

        return viewResolver;
    }

    // define a bean for our security datasource
    @Bean
    public DataSource myRestDataSource() {

        // create a connection pool
        ComboPooledDataSource myDataSource = new ComboPooledDataSource();

        // set jdbc driver class
        try {
            myDataSource.setDriverClass( env.getProperty( "spring.datasource.driver-class-name" ) );
        } catch (PropertyVetoException exc) {
            throw new RuntimeException( exc );
        }

        // log the connection properties
        logger.info( CYAN_BOLD + ">>> application.properties - jdbc.url = " + env.getProperty( "spring.datasource.url" ) + RESET );
        logger.info( CYAN_BOLD + ">>> application.properties - jdbc.username = " + env.getProperty( "spring.datasource.username" ) + RESET );
        logger.info( CYAN_BOLD + ">>> application.properties - jdbc.password = " + env.getProperty( "spring.datasource.password" ) + RESET );

        // set database connection properties
        myDataSource.setJdbcUrl( env.getProperty( "spring.datasource.url" ) );
        myDataSource.setUser( env.getProperty( "spring.datasource.username" ) );
        myDataSource.setPassword( env.getProperty( "spring.datasource.password" ) );


        // set connection pool properties
        myDataSource.setInitialPoolSize( getIntProperty( "connection.pool.initialPoolSize" ) );
        myDataSource.setMinPoolSize( getIntProperty( "connection.pool.minPoolSize" ) );
        myDataSource.setMaxPoolSize( getIntProperty( "connection.pool.maxPoolSize" ) );
        myDataSource.setMaxIdleTime( getIntProperty( "connection.pool.maxIdleTime" ) );


        return myDataSource;
    }

    private Properties getHibernateProperties() {

        // set hibernate properties
        Properties props = new Properties();

        props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

        return props;
    }

    // need a helper method
    // read environment property and convert to int
    private int getIntProperty(String propName) {
        String propValue = env.getProperty( propName );

        // convert string to int
        assert propValue != null;
        return Integer.parseInt( propValue );
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){

        // create session factories
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        // set the properties
        sessionFactory.setDataSource( myRestDataSource());
        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());

        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

        // setup transaction manager based on session factory
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }

}
