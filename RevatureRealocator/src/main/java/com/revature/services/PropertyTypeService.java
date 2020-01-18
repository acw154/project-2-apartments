package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.PropertyType;
import com.revature.repositories.PropertyTypeDAO;

public class PropertyTypeService {
	@Autowired
	PropertyTypeDAO ptdao;
	
	public PropertyTypeService(PropertyTypeDAO ptdao) {
		this.ptdao = ptdao;
	}
	
	public List<PropertyType> findAll(){
		return ptdao.findAll();
	}
	
	public boolean upsert(PropertyType pt) {
		ptdao.upsert(pt);
		if(ptdao.findById(pt.getId()).equals(pt)) {
			return true;
		}
		return false;
	}
	
	public boolean delete(PropertyType pt) {
		ptdao.delete(pt);
		if(ptdao.findById(pt.getId()) == null) {
			return true;
		}
		return false;
	}
	
	public PropertyType findById(int id) {
		return ptdao.findById(id);
	}
	
	public PropertyType findByType(String type) {
		return ptdao.findByType(type);
	}
}
