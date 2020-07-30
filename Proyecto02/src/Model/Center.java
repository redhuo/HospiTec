package Model;

public class Center {
	String id;
	String name;
	String type;
	int capacity;
	String direction;
	public Center (String id,String name,String type,int capacity,String direction) {
		this.id=id;
		this.name = name;
		this.type = type;
		this.capacity = capacity;
		this.direction = direction;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public int getCapacity() {
		return capacity;
	}
	public String getDirection() {
		return direction;
	}
}
