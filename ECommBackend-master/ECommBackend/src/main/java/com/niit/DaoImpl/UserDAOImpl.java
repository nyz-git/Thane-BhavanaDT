package com.niit.DaoImpl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.*;
import com.niit.model.*;

@Repository("UserDAO")
@Transactional
public class UserDAOImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFac;
	public boolean insertUser(User user)
	{
		Session session=sessionFac.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		return true;
		
	}
	@Override
	public List<User> retrieveUser() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public User getUser(int catId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		super();
		sessionFac=sessionFactory;
	}
	
	/*public List<User> retrieve()
	{
		Session session=sessionFac.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User> li=session.createQuery("from User").list();
		session.getTransaction().commit();
		return li;
	}*/

}
