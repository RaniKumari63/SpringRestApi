package com.suchiit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suchiit.entity.Tutorial;
@Repository
public interface TutorialRepo extends JpaRepository<Tutorial, Long> {
   
	List<Tutorial> findByPublished(boolean published);
  List<Tutorial> findByTitle(String title);
  
}
