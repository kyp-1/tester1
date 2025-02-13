package p0212;

public class ExamFood {
	private String name;
	private int price;
	private String type;
	private int piece;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setPiece(int piece) {
		this.piece = piece;
	}
	public String toString() {
		return "[이름 = " + name + ", 가격 = " + price + ", 종류 = " + type + ", 갯수 = " + piece + "개]";
	}
	

}
