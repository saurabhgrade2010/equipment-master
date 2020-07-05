package com.incture.dao;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.incture.entities.BasicData;


@Repository
public class BasicDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void add(BasicData data)
	{
		hibernateTemplate.save(data);
	}
	public ArrayList<BasicData> showBasicData()
	{
		ArrayList<BasicData> basicList = (ArrayList<BasicData>)hibernateTemplate.loadAll(BasicData.class);
		return basicList;
	}
}
