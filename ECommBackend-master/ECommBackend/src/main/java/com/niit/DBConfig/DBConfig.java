package com.niit.DBConfig;
import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.niit.DaoImpl.UserDAOImpl;
import com.niit.dao.UserDao;
import com.niit.model.Category;
import com.niit.model.User;


@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig {	
	
	// Datasource bean available
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/bhavanaecom";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";

	@Bean("dataSource")
	public DataSource getDataSource() {
		// providing the database connections
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);
		System.out.println("Done");

		return datasource;
	}

	// SessionFactory bean is available
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.niit.model");
		return builder.buildSessionFactory();
	}

	// Hibernate properties
	
	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;

	}

	// hibernate transaction bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}


