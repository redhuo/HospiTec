package Model;

public class Binnacle {
	String date;
	String status;
	String id;
	String workerid;
	
	public Binnacle(String date,String status,String id, String workerid) {
		this.date = date;
		this.status=status;
		this.id=id;
		this.workerid=workerid;
		
	}

	public String getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}

	public String getId() {
		return id;
	}

	public String getWorkerid() {
		return workerid;
	}
}
