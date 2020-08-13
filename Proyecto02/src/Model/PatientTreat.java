package Model;

public class PatientTreat {
	String patient;
	String treat;

	public PatientTreat(String patient,String treat) {
		this.patient = patient;
		this.treat = treat;
	}

	public String getPatient() {
		return patient;
	}

	public String getTreat() {
		return treat;
	}
}
