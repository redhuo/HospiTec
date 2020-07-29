package Model;

public class User {
	String Username;
	String Password;
	String Type;
	
	public User(String username,String password,String type) {
		this.Username = username;
		this.Password = password;
		this.Type = type;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
}
