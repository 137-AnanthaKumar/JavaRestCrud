package com.example.loginlogoutjwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.loginlogoutjwt.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	//@Query(value = "SELECT * FROM User u WHERE u.active_sta ='Active' ", nativeQuery = true)
	
//	@Query(value = "SELECT * FROM User WHERE email=:em AND password=:pass", nativeQuery = true)
//	User findByEmailAndPassword(@Param("em")String email,@Param("pass") String password);
	

	User findOneIgnoreCaseByEmailAndPassword(String email, String password);

	

}
