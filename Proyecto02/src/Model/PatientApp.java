package Model;

public class PatientApp {
	String patient;
	String app;
	
	public PatientApp(String patient,String app) {
		this.patient = patient;
		this.app = app;
	}

	public String getPatient() {
		return patient;
	}

	public String getApp() {
		return app;
	}
}
