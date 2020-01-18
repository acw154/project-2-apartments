package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="messages")
public class Message implements Serializable {

	private static final long serialVersionUID = 6209031195787199438L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="messages_id")
	private int id; 
	
	@Column
	@OneToMany(fetch = FetchType.EAGER)
	private int sender; 
	
	@Column 
	@OneToMany(fetch = FetchType.EAGER)
	private int receiver; 
	
	@Column 
	private String body; 
	
	
	public Message() {
		super();
	}
	public Message(int id, int sender, int receiver, String body) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.body = body;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getReceiver() {
		return receiver;
	}
	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + id;
		result = prime * result + receiver;
		result = prime * result + sender;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (id != other.id)
			return false;
		if (receiver != other.receiver)
			return false;
		if (sender != other.sender)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Messages [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", body=" + body + "]";
	} 
	
	
}
