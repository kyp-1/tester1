package p0221;

class Test{
	public String toString(int num) {
	 num = 10;
		return "3";
	}	
}
public class Overloading extends Test {
	
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.toString(3));
		Object o = new Overloading();
		System.out.println(o);
	}
}
