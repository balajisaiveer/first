package com.balaji.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.balaji.modal.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//public User findByUsernameAndPassword(String username,String password);
	List<User> findByUsername(String username);
	
	//@Query("select balance from User")
	//List<Balance> findbalance();
	
}
