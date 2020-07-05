package com.incture.services;

import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.incture.dao.BasicDao;
import com.incture.entities.BasicData;

@Service
public class BasicService {
	
	
	@Autowired
	private BasicDao basicDao;
	
	@Transactional
	public void add(BasicData basicData)
	{
		basicDao.add(basicData);
	}
	
	@Transactional
	public ArrayList<BasicData> showBasicData()
	{
		ArrayList<BasicData> l = basicDao.showBasicData();
		return l;
	}

}
