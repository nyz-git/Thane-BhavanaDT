package com.niit.dao;
import java.util.List;

import com.niit.model.Category;

public interface CategoryDao {
	
	public boolean insertCategory(Category category);
	public List<Category> retrieveCategory();
	public boolean deleteCategory(Category category);
	public Category getCategory(int catId);
	public boolean updateCategory(Category category);

}
