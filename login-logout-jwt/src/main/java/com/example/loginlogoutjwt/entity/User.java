package com.example.loginlogoutjwt.entity;

import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.example.loginlogoutjwt.commen.Constant;

import lombok.Data;

@Entity
@Table
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String password;
	@Column
	private int loginCount;
	@Column
	private boolean isActive;
	@Column
	private String userType=Constant.USER_TYPE.NORMAL;
	@Column
	private LocalDateTime loginAt;
	@Column
	private LocalDateTime createdAt;
	@Column
	private LocalDateTime updatedAt;
	
	
	
	
}
