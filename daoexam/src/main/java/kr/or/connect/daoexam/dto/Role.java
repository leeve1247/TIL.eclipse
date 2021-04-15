package kr.or.connect.daoexam.dto;

public class Role {
	private int roldID;
	private String description;
	public int getroldID() {
		return roldID;
	}
	public void setroldID(int roldID) {
		this.roldID = roldID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role [roldID=" + roldID + ", description=" + description + "]";
	}
}
