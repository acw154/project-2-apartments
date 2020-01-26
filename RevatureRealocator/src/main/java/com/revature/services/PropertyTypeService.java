package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.PropertyType;
import com.revature.repositories.PropertyTypeDAO;

@Service
public class PropertyTypeService {
	@Autowired
	PropertyTypeDAO ptdao;
	
	public PropertyTypeService(PropertyTypeDAO ptdao) {
		this.ptdao = ptdao;
	}
	
	
	
	
	
	public PropertyType findByType(String type) {
		return ptdao.findByType(type);
	}
}
