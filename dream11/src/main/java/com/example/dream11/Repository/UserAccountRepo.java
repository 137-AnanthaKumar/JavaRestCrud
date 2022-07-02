package com.example.dream11.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dream11.Entity.UserAccount;
@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount, Integer> {

	boolean existsByAccountName(String accountName);

}
