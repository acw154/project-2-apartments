package com.revature.repositories;

import java.util.List;

import com.revature.models.Message;

public interface MessageDAO {
	public List<Message> findAll();
	public Message findById(int id);
	public void save(Message m);
	public void update(Message m);
}
