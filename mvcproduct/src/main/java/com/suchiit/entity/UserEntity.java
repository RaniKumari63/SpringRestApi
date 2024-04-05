package com.suchiit.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user5")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private long userid;
private String email;
private String password;
private String address;
private String username;
private String rolename;
private String status;
@CreationTimestamp
@Column(updatable = false)
private Date createdAt;
@Column(insertable=false)
private Date updateAt;
}