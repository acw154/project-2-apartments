package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

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
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User sender; 
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User receiver; 
	
	@Column 
	private String body; 
	
	
	public Message() {
		super();
	}
	public Message(int id, User sender, User receiver, String body) {
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
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
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
		return Objects.hash(body, id, receiver, sender);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Message)) {
			return false;
		}
		Message other = (Message) obj;
		return Objects.equals(body, other.body) && id == other.id && Objects.equals(receiver, other.receiver)
				&& Objects.equals(sender, other.sender);
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", body=" + body + "]";
	}

	
	
}
