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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "testEntityManagerFactory", 
		transactionManagerRef = "testPlatformTransactionManager", basePackages = { "top.yudie.demo.jpa.test" })
public class TestDataSourceConfig {
	@Bean(name = "test") @Qualifier("test")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource.test")
	public DataSource testdataSource() {
	    return DataSourceBuilder.create().build();
	}
	
	@Bean(name ="testEntityManager")
	@Primary
	public EntityManager testEntityManager(@Qualifier("testEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return entityManagerFactory.createEntityManager();
	}
	
	@Bean(name = "testEntityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean testEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(testdataSource()).packages("top.yudie.demo.jpa.test")
				.persistenceUnit("testpersistenceUnit").build();
	}
	
	@Bean(name = "testPlatformTransactionManager")
	@Primary
	public PlatformTransactionManager testPlatformTransactionManager(
			@Qualifier("testEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	
}
