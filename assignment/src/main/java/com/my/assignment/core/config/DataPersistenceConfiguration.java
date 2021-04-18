
package com.my.assignment.core.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring configuration related to database and JPA.
 *
 * @author satheesh.arunachalam
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.my.assignment.integration.data.dao")
@EnableTransactionManagement
public class DataPersistenceConfiguration {

  @Bean
  public DataSource dataSource() {
    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    return builder.setType(EmbeddedDatabaseType.H2).build();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter jpaVendorAdapter) {
    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(jpaVendorAdapter);
    factory.setPackagesToScan("com.my.assignment.domain.data");
    factory.setDataSource(dataSource());
    return factory;
  }

  @Bean
  public JpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
    jpaVendorAdapter.setDatabase(Database.H2);
    jpaVendorAdapter.setGenerateDdl(true);
    return jpaVendorAdapter;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory, DataSource dataSource) {

    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);
    transactionManager.setDataSource(dataSource);
    // transactionManager.setJpaDialect(new HibernateJpaDialect());
    transactionManager.setRollbackOnCommitFailure(true);
    return transactionManager;
  }

}
