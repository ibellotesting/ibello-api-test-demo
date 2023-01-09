package hu.demoapi.data;

import hu.ibello.data.Model;

@Model
public class ApiResponse {

	private int code;
	
	private String type;
	
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return String.format("%d: %s", code, message);
	}
	
}
