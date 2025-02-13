package p0212;

import java.util.ArrayList;

public class ExamListTest1 {

	public static void main(String[] args) {
		ExamFood ef1 = new ExamFood();
		ef1.setName("당근");
		ef1.setPrice(1300);
		ef1.setType("채소");
		ef1.setPiece(8);
		
		ExamFood ef2 = new ExamFood();
		ef2.setName("사과");
		ef2.setPrice(2300);
		ef2.setType("과일");
		ef2.setPiece(3);
		
		ExamFood ef3 = new ExamFood();
		ef3.setName("고등어");
		ef3.setPrice(4000);
		ef3.setType("생선");
		ef3.setPiece(5);
		
		ExamFood ef4 = new ExamFood();
		ef4.setName("새우깡");
		ef4.setPrice(1800);
		ef4.setType("과자");
		ef4.setPiece(1);
		
		ArrayList<ExamFood> foods = new ArrayList<>();
		foods.add(ef1);
		foods.add(ef2);
		foods.add(ef3);
		foods.add(ef4);
		
		for(ExamFood ef:foods) {
			System.out.println(ef);
		}
		
		System.out.println();
		
		for(int i=0;i<foods.size();i++) {
			ExamFood ef = foods.get(i);
			System.out.println(ef);
		}
		
	}
}
