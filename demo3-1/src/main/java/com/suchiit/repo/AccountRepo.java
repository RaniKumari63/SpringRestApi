 package com.suchiit.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.suchiit.model.Account;
@Repository
//public interface AccountRepo extends JpaRepository<Account, Long>{
	public interface AccountRepo extends PagingAndSortingRepository<Account, Long>{	
List<Account> findByAccname(String accname);
//select * from table where accname="" and department=""
List<Account> findByAccnameAndDepartment(String accname, String department);


///select * from table where like  "%rani%"
List<Account> findByAccnameContaining(String keyword,Sort sort);
List<Account> findByAccnameLike(String keyword);


//@Query("from AccountEntity where accname=:accname or department=:department")
//List<Account> getEmployeeByNameAndLocation(String accname,String department);
 

//@Query("from AccountEntity where accname=:accname")
//List<Account> getEmployeeByNameAndLocation(@Param("accname") String abc,String department);

//@Modifying
//@Transactional
//@Query("Delete from AccountEntity where accname=:accname")
 //Integer deleteAccountByAccName(String accname);
}
