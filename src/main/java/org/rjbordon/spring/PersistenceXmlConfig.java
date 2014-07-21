package org.rjbordon.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by rjbordon on 7/18/14.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({"org.rjbordon.persistence.dao", "org.rjbordon.persistence.service"})
@ImportResource({"classpath:hibernate.xml"})
public class PersistenceXmlConfig {
    public PersistenceXmlConfig() {
        super();
    }
}