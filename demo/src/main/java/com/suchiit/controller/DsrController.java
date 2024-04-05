package com.suchiit.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suchiit.exception.RecordNotFoundException;
import com.suchiit.model.Dsr;
import com.suchiit.model.Project;
import com.suchiit.service.DsrService;

@RestController
@RequestMapping("/restapi/dsr")
public class DsrController {
@Autowired
DsrService dsrserviceimpl;
@PostMapping("/addDsr")
public ResponseEntity<String> saveDsr(@RequestBody Dsr dsr) {
	String msg = "";
	Dsr savedsr = dsrserviceimpl.saveDsr(dsr);
	if (savedsr != null) {
		msg = "Data Inserted Successfully";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);

	} else {
		msg = "Data not  Inserted Successfully";
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

}
@GetMapping("/fetchDsr")
public List<Dsr> getAllDsr() {
	return dsrserviceimpl.getAllDsrReports();

}


@PutMapping("/update/{dsrid}")
public ResponseEntity<String> updateDsr(@RequestBody Dsr dsr, @PathVariable("dsrid") long dsrid)
		throws RecordNotFoundException {
	String msg = "";
	Dsr updatedsr = dsrserviceimpl.updateDsrById(dsr, dsrid);
	if (updatedsr != null) {
		msg = "Data Updated Successfully";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);

	} else {
		msg = "Data not  Updated Successfully";
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

}


@DeleteMapping("/delete/{dsrid}")
public ResponseEntity<String> deleteDsr(@PathVariable("dsrid") long dsrid) throws RecordNotFoundException {
	String msg = "";
	boolean flag = false;

	flag = dsrserviceimpl.deleteDsrById(dsrid);		
	
	if (flag) {
		msg = "Data deleted Successfully";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	} else {
		
		msg = "Data not  deleted Successfully";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}


@GetMapping("/fetchDsrDate")
public List<Dsr> getAllDsrReportsWithDate(@RequestParam("sdate") Date sdate,@RequestParam("edate") Date edate) {
	return dsrserviceimpl.getAllDsrReportsWithDate(sdate,edate);

}


}
