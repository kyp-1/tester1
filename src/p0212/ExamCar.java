package p0212;

import java.util.ArrayList;

public class ExamCar {

	public static void main(String[] args) {
		Car c1 = new Car();
		c1.setName("523d");
		c1.setBodyType("세단");
		c1.setColor("은색");
		c1.setWheelDrive("4륜구동");
		c1.setBrand("BMW");
		c1.setPrice(78000000);
		
		Car c2 = new Car();
		c2.setName("모델3");
		c2.setBodyType("세단");
		c2.setColor("파란색");
		c2.setWheelDrive("후륜구동");
		c2.setBrand("테슬라");
		c2.setPrice(47000000);
		
		Car c3 = new Car();
		c3.setName("셀토스");
		c3.setBodyType("SUV");
		c3.setColor("흰색");
		c3.setWheelDrive("전륜구동");
		c3.setBrand("기아");
		c3.setPrice(29000000);
		
		ArrayList<Car> cars = new ArrayList<>();
		cars.add(c1);
		cars.add(c2);
		cars.add(c3);
		
		for(int i=0;i<cars.size();i++) { //cars 라고 선언한 어레이리스트 사이즈보다 작게
			Car c = cars.get(i);
			System.out.println(c);
		}
		
		for(Car c:cars) {
			System.out.println(c);
		}
	}
}
