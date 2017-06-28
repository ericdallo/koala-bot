package br.com.koala.configuration;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { JPAConfiguration.PACKAGES_TO_SCAN })
class JPAConfiguration {
	
	static final String PACKAGES_TO_SCAN = "br.com.koala";

	@Autowired
	private Environment env;

	@Bean
	@Scope(SCOPE_SINGLETON)
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan(PACKAGES_TO_SCAN);

		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));

		entityManagerFactoryBean.setJpaProperties(properties);

		return entityManagerFactoryBean;
	}

	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);

		return transactionManager;
	}
}

