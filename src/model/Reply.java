package model;

import java.io.Serializable;

public class Reply implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String replyId;
	private String name;
	private String description;
	private String proffesions;
	private int counter = 0; // only for tests!
	
	public Reply(){}

	public Reply(String replyId, String name, String description, String proffesions) {
		super();
		this.replyId = replyId;
		this.name = name;
		this.description = description;
		this.proffesions = proffesions;
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProffesions() {
		return proffesions;
	}

	public void setProffesions(String proffesions) {
		this.proffesions = proffesions;
	}
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public void incCounter() {
		counter++;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Reply) {
			Reply reply = (Reply) obj;
			if(reply.getReplyId().equals(replyId)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		} 
	}

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", counter=" + counter + "]";
	}
	
	
	
	
}
