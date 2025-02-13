package p0212;

public class Car {

	private String name;
	private String bodyType;
	private String color;
	private String wheelDrive;
	private String brand;
	private int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getWheelDrive() {
		return wheelDrive;
	}
	public void setWheelDrive(String wheelDrive) {
		this.wheelDrive = wheelDrive;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
		
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", bodyType=" + bodyType + ", color=" + color + ", wheelDrive=" + wheelDrive
				+ ", brand=" + brand + ", price=" + price + "]";
	}
}
