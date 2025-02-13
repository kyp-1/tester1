package p0212;

class Mother{
	final void test() {
		System.out.println("난 엄마 테스트()");
	}
}
public class FinalMethod extends Mother{
	void test(int a) {
		System.out.println("그냥 테스트()");
	}
	public static void main(String[] args) {
		FinalMethod fm = new FinalMethod();
		fm.test();
		Mother m = new FinalMethod(); 
		m.test();
		//class(상속 불가) method(오버라이딩 불가) 변수(상수로 변환)에 final 사용 가능
		
	
	}
}
