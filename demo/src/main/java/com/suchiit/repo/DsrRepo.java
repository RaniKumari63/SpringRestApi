package com.suchiit.repo;



import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.suchiit.entity.DsrEntity;


public interface DsrRepo extends JpaRepository<DsrEntity, Integer> {
	@Query(value="select * from dsr where  visibility=true and dsr_date between ?1 and ?2",nativeQuery = true)
	List<DsrEntity> findAllBySDateEDate(Date sdate,Date edate);
	
	
	@Query(value="select * from dsr where visibility=true ",nativeQuery = true)
	public List<DsrEntity> findAllDsrs();
	
	@Query(value="select * from dsr where visibility=true and dsr_id=?1 ",nativeQuery = true)
	public DsrEntity findAllDsrsById(long dsrid);
	
	@Modifying
    @Transactional
	@Query(value="update DsrEntity set visibility=false where dsr_id=?1")
	public void  deleteDsr(long id) ;
}