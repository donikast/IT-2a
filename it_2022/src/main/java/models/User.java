package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String personalName;
	private String username;
	private String password;
	private String jobTitle;
	private String description;
	private String email;
	private String phone;
	private Address address;
	private List<Skill> itSkills;
	private List<Skill> personalSkills;
	
	public User() {}

	public User(String personalName, String username, String password) {
		this.personalName = personalName;
		this.username = username;
		this.password = password;
		
		address = new Address();
		this.itSkills = new ArrayList<Skill>();
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getPersonalName() {
		return personalName;
	}

	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
}
