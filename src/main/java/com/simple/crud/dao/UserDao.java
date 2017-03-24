/**
 * 
 */
package com.simple.crud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.simple.crud.model.Users;

/**
 * @author eotayde
 *
 */
@Repository
public interface UserDao {

	void create(Users user);
	
	void update(Users user);
	
	void deleteById(int id);
	
	Users findById(int id);
	
	List<Users> findAll();
	
}
