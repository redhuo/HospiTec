package Model;

public class WAC {
	String id;
	String area;
	String center;
	public WAC(String id,String area,String center) {
		this.id = id;
		this.area = area;
		this.center = center;
	}
	public String getId() {
		return id;
	}
	public String getArea() {
		return area;
	}
	public String getCenter() {
		return center;
	}
}
