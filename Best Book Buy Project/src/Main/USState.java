package Main;

import java.util.ArrayList;

public enum USState {
	AL("AL", "Alabama"), MI("MI", "Michigan"), 
	NE("NE", "Nebraska");

	private String code;
	private String name;

	private USState(String c, String n) {
		code = c;
		name = n;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return code + " - " + name;
	}
}
