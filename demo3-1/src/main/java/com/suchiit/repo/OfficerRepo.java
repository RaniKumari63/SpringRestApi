package com.suchiit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suchiit.model.Officer;
@Repository
public interface OfficerRepo extends JpaRepository<Officer,Long>{

}
