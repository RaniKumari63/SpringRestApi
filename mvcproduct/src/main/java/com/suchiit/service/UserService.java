package com.suchiit.service;

import java.util.List;

import com.suchiit.entity.UserEntity;
import com.suchiit.exception.RecordNotFoundException;
import com.suchiit.model.User;

public interface UserService {
	public UserEntity getUserByEmailandPassword(String email,String password);
	public User RegisterUser(User user);
	public List<User> getAllUser();
	public boolean deleteUser(long id) throws RecordNotFoundException;
	public boolean changepassword(long id,String cpassword) throws RecordNotFoundException;
	public User getUserById(long id);
}
