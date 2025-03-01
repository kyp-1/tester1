package p0212;

import java.util.ArrayList;

public class ListTest {

	public static void main(String[] args) {
		ArrayList<Human> people = new ArrayList<>(); //Human
		for(int i=1;i<=10;i++) {
			Human h = new Human();
			//0-0.999999 * => 0-99.9999 => 0-99 + 1 =>1-100
			int age = (int)(Math.random() * 100)+1;
			// 0-0.99999 * 50 => 0-49.9999=> 0-49 + 50 => 50-99
			int weight = (int)(Math.random() * 50 ) + 50;
			h.setName("이름" + i); //이름1 이름2 이름3 순으로 표현하기위해서 사용
			h.setAddress("주소" + i); //위와 동일
			h.setAge(age); //age값 랜덤으로 설정한것 대입
			h.setWeight(weight); //weight값 랜덤으로 설정한것 대입
			people.add(h); //생성후 people변수에 대입(h.toString())
		}
		System.out.println(people);
		for(int i=0;i<people.size();i++) {
			Human h = people.get(i);
			System.out.println(h);
		}
		for(Human h:people) {
			System.out.println(h);
		}
	}
}
