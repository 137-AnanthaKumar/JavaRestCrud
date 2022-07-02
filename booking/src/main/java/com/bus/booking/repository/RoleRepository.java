package com.bus.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.booking.model.ERole;
import com.bus.booking.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(ERole roleAdmin);

}
