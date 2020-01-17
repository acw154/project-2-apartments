package com.revature.models;

public class Messages {

	public int id; 
	public int sender; 
	public int receiver; 
	public String body;
	public Messages() {
		super();
	}
	public Messages(int id, int sender, int receiver, String body) {
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
		Messages other = (Messages) obj;
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
