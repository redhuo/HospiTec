package Model;

public class Diagnostic {
	String level;
	String catalogue_id;
	String patient_id;
	String observation;
	public Diagnostic(String level,String catalogue_id,String patient_id,String observation) {
		this.level = level;
		this.catalogue_id = catalogue_id;
		this.patient_id=patient_id;
		this.observation = observation;
	}
	public String getLevel() {
		return level;
	}
	public String getCatalogue_id() {
		return catalogue_id;
	}
	public String getPatient_id() {
		return patient_id;
	}
	public String getObservation() {
		return observation;
	}
}
