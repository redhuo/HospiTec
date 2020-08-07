	package Model;

public class Worker{
	String id;
	String name;
	String surname1;
	String surname2;
	String type;
	String entry;
	
	public Worker (String id, String name, String surname1, String surname2, String type, String entry) {
		this.id= id;
		this.name= name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.type=type;
		this.entry = entry;
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

	public String getType() {
		return type;
	}

	public String getEntry() {
		return entry;
	}
}
