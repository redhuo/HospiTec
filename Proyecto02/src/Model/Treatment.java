package Model;

public class Treatment {
	String patient;
	String name;
	String dose;
	String type;
	public Treatment(String patient,String name,String dose,String type) {
		
		this.patient=patient;
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
	public String getPatient() {
		return patient;
	}
}
