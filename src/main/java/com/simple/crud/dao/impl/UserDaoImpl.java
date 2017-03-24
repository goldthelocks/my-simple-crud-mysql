/**
 * 
 */
package com.simple.crud.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.crud.dao.UserDao;
import com.simple.crud.model.Users;

/**
 * @author eotayde
 *
 */
@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see com.simple.crud.dao.UserDao#create(com.simple.crud.model.User)
	 */
	public void create(Users user) {
		sessionFactory.getCurrentSession().save(user);
	}

	/* (non-Javadoc)
	 * @see com.simple.crud.dao.UserDao#update(com.simple.crud.model.User)
	 */
	public void update(Users user) {
		sessionFactory.getCurrentSession().update(user);
	}

	/* (non-Javadoc)
	 * @see com.simple.crud.dao.UserDao#deleteById(int)
	 */
	public void deleteById(int id) {
		Users user = sessionFactory.getCurrentSession().load(Users.class, id);
		if (user != null) {
			sessionFactory.getCurrentSession().delete(user);
		}
	}

	/* (non-Javadoc)
	 * @see com.simple.crud.dao.UserDao#findById(int)
	 */
	public Users findById(int id) {
		return sessionFactory.getCurrentSession().get(Users.class, id);
	}

	/* (non-Javadoc)
	 * @see com.simple.crud.dao.UserDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<Users> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Users").list();
	}

}
