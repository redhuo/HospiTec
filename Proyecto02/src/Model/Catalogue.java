package Model;

public class Catalogue {
	String id;
	String name;
	String treat;
	public Catalogue(String id,String name,String treat) {
		this.id = id;
		this.name=name;
		this.treat = treat;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTreat() {
		return treat;
	}
	public void setTreat(String treat) {
		this.treat = treat;
	}
}
