package p0212;

import java.util.ArrayList;

public class ExamComputer {

	public static void main(String[] args) {
		Computer c1 = new Computer();
		c1.setCpu("12400F");
		c1.setRam("24GB");
		c1.setHdd("300G");
		
		Computer c2 = new Computer();
		c2.setCpu("14600K");
		c2.setRam("32GB");
		c2.setHdd("2TB");
		
		Computer c3 = new Computer();
		c3.setCpu("11900K");
		c3.setRam("64GB");
		c3.setHdd("4TB");
		
		Computer c4 = new Computer();
		c4.setCpu("9400F");
		c4.setRam("16GB");
		c4.setHdd("500G");
		
		Computer c5 = new Computer();
		c5.setCpu("8700K");
		c5.setRam("8GB");
		c5.setHdd("100G");
		
		ArrayList<Computer> coms = new ArrayList<>();
		coms.add(c1);
		coms.add(c2);
		coms.add(c3);
		coms.add(c4);
		coms.add(c5);
		
		for(int i=0;i<coms.size();i++) {
			Computer c = coms.get(i);
			System.out.println(c);
		}
		
		for(Computer c:coms) {
			System.out.println(c);
		}
	}
}
