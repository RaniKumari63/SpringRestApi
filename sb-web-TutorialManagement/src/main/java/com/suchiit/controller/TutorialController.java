package com.suchiit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suchiit.entity.Tutorial;
import com.suchiit.repo.TutorialRepo;

@RestController
@RequestMapping("/api")
public class TutorialController {
@Autowired
private TutorialRepo daoImpl;
@PostMapping("/createtutorials")
public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial)
{
	Tutorial tutEnt=daoImpl.save(tutorial);
	if(tutEnt!=null)
	{
		return new ResponseEntity<Tutorial>(tutEnt,HttpStatus.CREATED);
	}
	else
	{
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
@GetMapping("/gettutorials")
public ResponseEntity<List<Tutorial>> getAllTutorials()
{
	List<Tutorial> tutorialInfo=daoImpl.findAll();
	
	return new ResponseEntity<List<Tutorial>>(tutorialInfo,HttpStatus.OK);
	
}

@GetMapping("/gettutorialsbypublished")
public ResponseEntity<List<Tutorial>> getAllTutorialsByPublished(@RequestParam("published") boolean published)
{
	List<Tutorial> tutorialInfo=daoImpl.findByPublished(published);
	
	return new ResponseEntity<List<Tutorial>>(tutorialInfo,HttpStatus.OK);
	
}
@GetMapping("/gettutorialsbytitle")
public ResponseEntity<List<Tutorial>> getAllTutorialsByTitle(@RequestParam("title") String title)
{
	List<Tutorial> tutorialInfo=daoImpl.findByTitle(title);
	
	return new ResponseEntity<List<Tutorial>>(tutorialInfo,HttpStatus.OK);
	
}

}
