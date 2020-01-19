package com.revature.repositories;

import java.util.List;

import com.revature.models.PropertyType;

public interface PropertyTypeDAO {
	public List<PropertyType> findAll();
	public void upsert(PropertyType pt);
	public void delete(PropertyType pt);
	public PropertyType findById(int id);
	public PropertyType findByType(String type);
}
