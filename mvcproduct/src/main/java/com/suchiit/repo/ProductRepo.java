package com.suchiit.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.suchiit.entity.ProductEntity;

@Repository
public interface ProductRepo  extends JpaRepository<ProductEntity, Long>{

	@Modifying
    @Transactional
	@Query(value="update ProductEntity set visibility=false where id=?1")
	public void  deleteProduct(long id) ;
	@Query(value="select * from product99 where visibility=true ",nativeQuery = true)
	public List<ProductEntity> findAllProducts();
}
