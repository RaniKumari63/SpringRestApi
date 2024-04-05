package com.suchiit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.suchiit.model.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class AccountEntity {
private long accno;
//@NotNull
//@NotEmpty(message="name should not be null")
@NotBlank(message="name should not be null")
private String accname;

private Long age=0L;
@NotNull
private String department;
private String acctype;
@CreationTimestamp
@Column(updatable = false)
private Date createdBy;
@UpdateTimestamp
@Column(insertable = false)
private Date updatedBy;

}

