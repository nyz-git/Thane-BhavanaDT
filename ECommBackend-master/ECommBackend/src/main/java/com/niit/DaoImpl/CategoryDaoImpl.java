package com.niit.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.dao.CategoryDao;
import com.niit.model.Category;


@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional	
	@Override
	public boolean insertCategory(Category category){
		try
        {        
			Session session=sessionFactory.getCurrentSession();
	        session.save(category);
        
        return true;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        return false;
        }
		
	}


	@Override
	public List<Category> retrieveCategory() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listCategory=query.list();
		session.close();
		return listCategory;
	}

    @Transactional
	@Override
	public boolean deleteCategory(Category category) {
		try
		{
		Session session=sessionFactory.getCurrentSession();
		session.delete(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);	
		return false;
		}
		
	}


	@Override
	public Category getCategory(int catId) {
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,catId);
		session.close();
		return category;
	}

    @Transactional
	@Override
	public boolean updateCategory(Category category) {
    	try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
		
	}
	
	
	
	
	
	

}
