package Model;

public class Appointment {
	String id;
	String area;
	String day;
	String hour;
	String status;
	String center_id;
	public Appointment(String id,String area,String day, String hour,String status,String center_id) {
		this.id=id;
		this.area=area;
		this.day=day;
		this.hour=hour;
		this.status=status;
		this.center_id=center_id;
	}
	public String getId() {
		return id;
	}
	public String getArea() {
		return area;
	}
	public String getDay() {
		return day;
	}
	public String getHour() {
		return hour;
	}
	public String getStatus() {
		return status;
	}
	public String getCenter_id() {
		return center_id;
	}
}
