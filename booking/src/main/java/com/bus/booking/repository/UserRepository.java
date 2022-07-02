package com.bus.booking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bus.booking.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	  Optional<User> findByUsername(String username);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

	 @Query(value="SELECT * FROM users  WHERE username=:username",nativeQuery = true)
     User findByUserName(String username);

}
