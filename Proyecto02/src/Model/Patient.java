package Model;

public class Patient {

	String id;
	String name;
	String surname1;
	String surname2;
	String email;
	String nationality;
	String blood;
	String state;
	String birth;
	
	public Patient(String id,String name,String surname1,String surname2, String email, String nationality,String blood,String state,String birth) {
		this.id = id;
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.email = email;
		this.nationality = nationality;
		this.blood = blood;
		this.state = state;
		this.birth = birth;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname1() {
		return surname1;
	}

	public String getSurname2() {
		return surname2;
	}

	public String getEmail() {
		return email;
	}

	public String getNationality() {
		return nationality;
	}

	public String getBlood() {
		return blood;
	}

	public String getState() {
		return state;
	}

	public String getBirth() {
		return birth;
	}
}
