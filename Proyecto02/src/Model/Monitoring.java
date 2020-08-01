package Model;

public class Monitoring {
	String date;
	String observation;
	String hospicode;
	String treatname;
	String workerid;
	
	public Monitoring(String date,String observation,String hospicode, String treatname,String workerid) {
		this.date = date;
		this.observation =observation;
		this.hospicode=hospicode;
		this.treatname=treatname;
		this.workerid=workerid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getHospicode() {
		return hospicode;
	}

	public void setHospicode(String hospicode) {
		this.hospicode = hospicode;
	}

	public String getTreatname() {
		return treatname;
	}

	public void setTreatname(String treatname) {
		this.treatname = treatname;
	}

	public String getWorkerid() {
		return workerid;
	}

	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}
	
}
