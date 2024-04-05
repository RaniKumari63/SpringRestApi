package com.suchiit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suchiit.entity.ProductEntity;
import com.suchiit.entity.UserEntity;
import com.suchiit.exception.RecordNotFoundException;
import com.suchiit.model.Product;
import com.suchiit.model.User;
import com.suchiit.repo.UserRepo;
import com.suchiit.service.UserService;

@Service
public class UserServiceImpl implements  UserService {

	@Autowired
	UserRepo userrepo;
		@Override
		public UserEntity getUserByEmailandPassword(String email,String password) {
		         
			UserEntity userEn=userrepo.findByEmailandPassword(email,password);
			
			
			return userEn;
		}
		public User RegisterUser(User user)
		{ 
			UserEntity userEn=new UserEntity();
			BeanUtils.copyProperties(user, userEn);
		   userEn.setStatus("active");
			UserEntity userEnSave=userrepo.save(userEn);
			User usersave=new User();
			BeanUtils.copyProperties(userEnSave, usersave);
			return usersave;
			
		}
		@Override
		public List<User> getAllUser() {
			// TODO Auto-generated method stub
			
			List<UserEntity> findAllUser=userrepo.findAllUsers();
			List<User> allusers=new ArrayList<User>();
			findAllUser.forEach(u->
			
			{
				User user=new User();
				BeanUtils.copyProperties(u, user);
				allusers.add(user);
			}
					);
			return allusers;
			
		}
		@Override
		public User getUserById(long id) {
			// TODO Auto-generated method stub
			
			UserEntity userEn=userrepo.findUserbyId(id);
			User user=new User();
			
				BeanUtils.copyProperties(userEn, user);
			
			return user;
			
		}
		
		 @Override public boolean deleteUser(long id) throws RecordNotFoundException
		  {
		  
				boolean flag = false;
				UserEntity userentity = userrepo.findUserbyId(id);
				if (userentity.getUserid() != 0) {
					
					userrepo.deleteUserbyId(id);
				
					flag = true;

				} else {
					throw new RecordNotFoundException("Given Record is Not Exists");
				}

				return flag;
		  
		  }
		@Override
		public boolean changepassword(long id,String cpassword) throws RecordNotFoundException {
			// TODO Auto-generated method stub
			boolean flag = false;
			UserEntity userentity = userrepo.findById(id).get();
			if (userentity.getUserid() != 0) {
				
				userentity.setPassword(cpassword);
				UserEntity userEnSave=userrepo.save(userentity);
				flag = true;

			} else {
				throw new RecordNotFoundException("Given Record is Not Exists");
			}

			return flag;
		
		}
		
		
		
		
		
		
}
