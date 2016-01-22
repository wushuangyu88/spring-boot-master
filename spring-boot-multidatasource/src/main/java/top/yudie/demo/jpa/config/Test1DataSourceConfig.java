package top.yudie.demo.jpa.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "test1EntityManagerFactory", 
		transactionManagerRef = "test1PlatformTransactionManager", basePackages = { "top.yudie.demo.jpa.test1" })
public class Test1DataSourceConfig {
	@Bean(name = "test1") @Qualifier("test1")
	@ConfigurationProperties(prefix="spring.datasource.test1")
	public DataSource test1dataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	@Bean(name ="test1EntityManager")
	public EntityManager test1EntityManager(@Qualifier("test1EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return entityManagerFactory.createEntityManager();
	}
	
	@Bean(name = "test1EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean test1EntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(test1dataSource()).packages("top.yudie.demo.jpa.test1")
				.persistenceUnit("test1persistenceUnit").build();
	}
	
	@Bean(name = "test1PlatformTransactionManager")
	public PlatformTransactionManager test1PlatformTransactionManager(
			@Qualifier("test1EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
