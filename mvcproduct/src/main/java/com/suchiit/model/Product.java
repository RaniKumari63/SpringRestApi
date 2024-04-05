package com.suchiit.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Product {
	
private long id;
private String productName;
private String productPrice;
private String productDescription;

private Date createdAt;


private Date updateAt;
private boolean visibility;
}
