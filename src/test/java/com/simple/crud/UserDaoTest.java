/**
 * 
 */
package com.simple.crud;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simple.crud.dao.UserDao;
import com.simple.crud.model.Users;

/**
 * @author eotayde
 *
 */
public class UserDaoTest {

	private ApplicationContext context;
	private UserDao userDao;
	
	@Before
	public void before() {
		context = new ClassPathXmlApplicationContext("spring-beans.xml");
		userDao = (UserDao) context.getBean("userDaoImpl");
	}

	public void testDelete() {
		userDao.deleteById(2);
	}
	
	public void testUpdate() {
		Users oldUser = userDao.findById(2);
		oldUser.setFirstName("jayjay");
		userDao.update(oldUser);	
	}
	
	public void testGet() {
		try {
			Users user = userDao.findById(1);
			
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetAll() {
		List<Users> userList = userDao.findAll();
		
		for (Users u : userList) {
			System.out.println(u.toString());
		}
	}

	public void testAdd() {
		Users user = new Users();
		user.setFirstName("jay");
		user.setLastName("pogi");
		
		userDao.create(user);
		System.out.println("added!");
	}

}
