package com.example.Configs;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

    @Autowired
    private Environment environment;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public DataSource securityDataSource() {
        ComboPooledDataSource comboPooledSecurityDataSource = new ComboPooledDataSource();
        try {
        comboPooledSecurityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        logger.info(">>>>>> jdbc.url="+environment.getProperty("jdbc.driver"));
        logger.info(">>>>>> jdbc.user="+environment.getProperty("jdbc.user"));

        comboPooledSecurityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        comboPooledSecurityDataSource.setUser(environment.getProperty("jdbc.user"));
        comboPooledSecurityDataSource.setPassword(environment.getProperty("jdbc.password"));

        comboPooledSecurityDataSource.setInitialPoolSize(helperMethodConversionStringToInteger("connection.pool.initialPoolSize"));
        comboPooledSecurityDataSource.setMinPoolSize(helperMethodConversionStringToInteger("connection.pool.minPoolSize"));
        comboPooledSecurityDataSource.setMaxPoolSize(helperMethodConversionStringToInteger("connection.pool.maxPoolSize"));
        comboPooledSecurityDataSource.setMaxIdleTime(helperMethodConversionStringToInteger("connection.pool.maxIdleTime"));
        return comboPooledSecurityDataSource;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }


    private Integer helperMethodConversionStringToInteger(String string) {
        String propertyValue = environment.getProperty(string);
        if (propertyValue != null) {
            return Integer.parseInt(propertyValue);
        } else {
            throw new RuntimeException("Value not defined.");
        }
    }
}
