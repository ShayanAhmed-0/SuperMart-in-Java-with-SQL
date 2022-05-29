package hello;

public class Products {
	private int pID;
	private String pName;
	private int pPrice;
	
	public Products(int pID, String pName,int pPrice) {
		super();
		this.pID = pID;
		this.pName = pName;
		this.pPrice = pPrice;
	}

	public Products(String pName,int pPrice) {
		super();
		this.pName = pName;
		this.pPrice= pPrice;
	}

	public Products() {
		super();

	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	@Override
	public String toString() {
		return "Products [pID=" + pID + ", pName=" + pName + ", pPrice=" + pPrice + "]";
	}
	
	
}
