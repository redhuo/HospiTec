package Model;

public class Treatment {
	String name;
	String dose;
	String type;
	public Treatment(String name,String dose,String type) {
		this.name=name;
		this.dose = dose;
		this.type=type;
	}
	public String getName() {
		return name;
	}
	public String getDose() {
		return dose;
	}
	public String getType() {
		return type;
	}
}
