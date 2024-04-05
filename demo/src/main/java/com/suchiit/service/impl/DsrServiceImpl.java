package com.suchiit.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suchiit.entity.DsrEntity;
import com.suchiit.entity.ProjectEntity;
import com.suchiit.exception.RecordNotFoundException;
import com.suchiit.model.Dsr;
import com.suchiit.model.Project;
import com.suchiit.repo.DsrRepo;
import com.suchiit.service.DsrService;
@Service
public class DsrServiceImpl implements DsrService {
	@Autowired 
	DsrRepo dsrrepo;
	
	@Override
	public Dsr saveDsr(Dsr dsr) {
		DsrEntity dsrEn=new DsrEntity();
		BeanUtils.copyProperties(dsr, dsrEn);
		dsrEn.setVisibility(true);
		DsrEntity dsrEnSave=dsrrepo.save(dsrEn);
		Dsr dsr1 = new Dsr();
		BeanUtils.copyProperties(dsrEnSave, dsr1);
		return dsr1;
		
		
		
		
	}

	@Override
	public List<Dsr> getAllDsrReports() {
		// TODO Auto-generated method stub
				List<DsrEntity> dsrEn=dsrrepo.findAllDsrs();
				List<Dsr> alldsr=new ArrayList<Dsr>();
				dsrEn.forEach(d->{
					
					Dsr dsr=new Dsr();
					BeanUtils.copyProperties(d, dsr);
			alldsr.add(dsr);
				});
				return alldsr;
	}

	@Override
	public List<Dsr> getAllDsrReportsWithDate(Date sdate, Date edate) {
		List<DsrEntity> dsrEn=dsrrepo.findAllBySDateEDate(sdate,edate);
		List<Dsr> alldsr=new ArrayList<Dsr>();
		dsrEn.forEach(d->{
			
			Dsr dsr=new Dsr();
			BeanUtils.copyProperties(d, dsr);
	alldsr.add(dsr);
		});
		return alldsr;
	}

	@Override
	public Dsr getAllDsrReportsById(long id) throws RecordNotFoundException {
			// TODO Auto-generated method stub
			DsrEntity dsrentity = dsrrepo.findAllDsrsById(id);
			Dsr dsr = new Dsr();
			BeanUtils.copyProperties(dsrentity, dsr);
			return dsr;

		}
	
	
	
	@Override
	public Dsr updateDsrById(Dsr dsr, long id) throws RecordNotFoundException {
		DsrEntity dsrentity = dsrrepo.findAllDsrsById(id);
		if(dsrentity!=null)
		{
		if (dsrentity.getDsr_id() != 0) {
			BeanUtils.copyProperties(dsr, dsrentity);

		} 
		}else {
			
			throw new RecordNotFoundException("Given Record is Not Exists");
		}
		DsrEntity saveEntity = dsrrepo.save(dsrentity);
		Dsr dsr1 = new Dsr();
		BeanUtils.copyProperties(saveEntity, dsr1);
		return dsr1;
	}

	@Override
	public boolean deleteDsrById(long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		boolean flag = false;
		DsrEntity dsrentity = dsrrepo.findAllDsrsById(id);
		if(dsrentity!=null)
		{
		if (dsrentity.getDsr_id() != 0) {
			dsrrepo.deleteDsr(id);
			flag = true;
		}
		}else {
	
			throw new RecordNotFoundException("Given Record is Not Exists");
		}

		return flag;

	}

	}


