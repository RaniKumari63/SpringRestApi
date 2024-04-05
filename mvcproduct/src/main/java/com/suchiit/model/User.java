package com.suchiit.model;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
private long userid;
private String email;
private String password;
private String address;
private String username;
private String rolename;
private String status;
private Date createdAt;
private Date updateAt;
}
