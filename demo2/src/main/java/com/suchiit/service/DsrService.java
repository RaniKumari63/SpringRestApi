package com.suchiit.service;

import java.util.Date;
import java.util.List;

import com.suchiit.exception.RecordNotFoundException;
import com.suchiit.model.Dsr;

public interface DsrService {
	public Dsr saveDsr(Dsr dsr);
	public List<Dsr> getAllDsrReports();
	public Dsr getAllDsrReportsById(long id) throws RecordNotFoundException ;
	public List<Dsr> getAllDsrReportsWithDate(Date sdate,Date edate);
	public Dsr updateDsrById(Dsr dsr, long id) throws RecordNotFoundException;
	public boolean deleteDsrById(long id) throws RecordNotFoundException ;
}
