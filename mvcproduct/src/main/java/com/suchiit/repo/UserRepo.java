package com.suchiit.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.suchiit.entity.ProductEntity;
import com.suchiit.entity.UserEntity;
@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long>{
	
	
	@Modifying
	@Transactional
	@Query(value="update UserEntity set status='inactive'  where userid=?1")
	public void deleteUserbyId(long id);
	
	@Query(value="select * from user5 where status='active' ",nativeQuery = true)
	public List<UserEntity> findAllUsers();

	
	@Query(value="select * from user5 where status='active' and  userid=?1 ",nativeQuery = true)
	public UserEntity findUserbyId(long id);
	
	UserEntity findByEmail(String email);

	public default UserEntity findByEmailandPassword(String email, String password) {

		UserEntity userEn = findByEmail(email);

		if (userEn != null) {
			if (userEn.getPassword().equals(password)) {
				return userEn;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}
}
