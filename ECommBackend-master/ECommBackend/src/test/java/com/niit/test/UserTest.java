package com.niit.test;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.model.User;

public class UserTest {
	
static UserDao userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit.model");
		configApplnContext.refresh();		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");		
		userDAO=(UserDao)configApplnContext.getBean("UserDAO");
	}
	
	
	@Test
	public void insertUserTest()
	{
		User user=new User();
		user.setName("user");
		user.setPassword("password");
		user.setEmail("niit@gmail.com");	
		assertEquals("Successfully added a user inside a table", true, userDAO.insertUser(user));}

	
}
