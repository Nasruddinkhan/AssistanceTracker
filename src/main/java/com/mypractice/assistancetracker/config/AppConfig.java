package com.mypractice.assistancetracker.config;

import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.CACHE_REGION_FACTORY;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.PASS;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;
import static org.hibernate.cfg.AvailableSettings.USE_SECOND_LEVEL_CACHE;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mypractice.assistancetracker.model.Address;
import com.mypractice.assistancetracker.model.Authorities;
import com.mypractice.assistancetracker.model.City;
import com.mypractice.assistancetracker.model.Country;
import com.mypractice.assistancetracker.model.MstCode;
import com.mypractice.assistancetracker.model.NeedyReffered;
import com.mypractice.assistancetracker.model.PaymentMode;
import com.mypractice.assistancetracker.model.PersistentLogins;
import com.mypractice.assistancetracker.model.PinCode;
import com.mypractice.assistancetracker.model.Profession;
import com.mypractice.assistancetracker.model.Reason;
import com.mypractice.assistancetracker.model.Relationship;
import com.mypractice.assistancetracker.model.State;
import com.mypractice.assistancetracker.model.User;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.mypractice.assistancetracker.dao"),
		@ComponentScan("com.mypractice.assistancetracker.daoimpl"),
		@ComponentScan("com.mypractice.assistancetracker.serviceimpl"),
		@ComponentScan("com.mypractice.assistancetracker.exception"),
		@ComponentScan("com.mypractice.assistancetracker.service"),
		@ComponentScan("com.mypractice.assistancetracker.validation") })
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		Properties props = new Properties();
		// Setting JDBC properties
		props.put(DRIVER, env.getProperty("mysql.driver"));
		props.put(URL, env.getProperty("mysql.jdbcUrl"));
		props.put(USER, env.getProperty("mysql.username"));
		props.put(PASS, env.getProperty("mysql.password"));
		// Setting Hibernate properties
		props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
		props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		// Setting C3P0 properties
		props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
		props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
		props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
		props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
		props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
		props.put(USE_SECOND_LEVEL_CACHE, env.getProperty("hibernate.cache.second_level_cache"));
		props.put(CACHE_REGION_FACTORY, env.getProperty("hibernate.cache.ehcache"));
	//	props.put(QUERY_CACHE_FACTORY, env.getProperty("hibernate.cache.second_level_cache"));
		factoryBean.setHibernateProperties(props);
		factoryBean.setAnnotatedClasses(User.class, Authorities.class, City.class, PersistentLogins.class,NeedyReffered.class,
				MstCode.class, Country.class, State.class, PinCode.class, PaymentMode.class,Address.class, Relationship.class, Profession.class, Reason.class);
		//factoryBean.setValidationMode(ValidationMode.NONE); 
		return factoryBean;
	}
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
}
