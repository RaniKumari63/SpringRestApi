package com.suchiit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product99")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String productName;
private String productPrice;
private String productDescription;
@CreationTimestamp
@Column(updatable = false)
private Date createdAt;
@UpdateTimestamp
@Column(insertable  = false)
private Date updateAt;


private boolean visibility;
}
