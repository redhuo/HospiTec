package Model;

public class CatTreat {
	String catid;
	String treat;
	public CatTreat(String catid,String treat) {
		this.catid=catid;
		this.treat = treat;
	}
	public String getCatid() {
		return catid;
	}
	public String getTreat() {
		return treat;
	}
}
