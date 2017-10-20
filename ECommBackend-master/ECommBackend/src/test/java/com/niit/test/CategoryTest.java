package com.niit.test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.CategoryDao;
import com.niit.model.Category;

public class CategoryTest {
	static CategoryDao categoryDao;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext configApplnContext = new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit");
		configApplnContext.refresh();
		// SessionFactory
		// sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		categoryDao = (CategoryDao) configApplnContext.getBean("categoryDao");
	}

	@Test
	public void insertCategoryTest() {
		Category category = new Category();
		category.setCid(102);
		category.setCname("Desktop");
		category.setCatDesc("all kinds of desktops ");
		assertEquals("Successfully added a user inside a table", true, categoryDao.insertCategory(category));
	}


	@Ignore
	@Test
	public void getCategoryTest() {
		Category category = categoryDao.getCategory(101);
		System.out.println("Calling retrieve test case");
		assertNotNull("Problem in Getting:", category);
		System.out.println("Category Desc:" + category.getCid());
		System.out.println("Category Name:" + category.getCname());
		System.out.println("Category Description  = " + category.getCatDesc());
	}

	@Ignore
	@Test
	public void updateCategoryTest() {
		Category category = new Category();
		category.setCid(1002);
		category.setCname("laptops");
		category.setCatDesc("All sorts of laptops");
		assertTrue(categoryDao.updateCategory(category));
	}

	@Ignore
	@Test
	public void deleteCategoryTest() {
		Category category = new Category();
		category.setCid(1002);
		assertTrue(categoryDao.deleteCategory(category));
	}

	@Ignore
	@Test
	public void retrieveCategoryTest() {
		List<Category> listCategory = categoryDao.retrieveCategory();
		assertNotNull("Problem in Retriving ", listCategory);
		this.show(listCategory);
	}

	public void show(List<Category> listCategory) {
		for (Category category : listCategory) {
			System.out.println("Category ID:" + category.getCid());
			System.out.println("Category Name:" + category.getCname());
		}
	}
}