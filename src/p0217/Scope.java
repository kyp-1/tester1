package p0217;

public class Scope {
	public Scope() {
		System.out.println("1");
	}
	static{
		System.out.println("2"); //접근제어자, 데이터타입, 이름 없으나 static nonstatic은 구분 가능
	}
	public static void main(String[] args) {
		System.out.println("3");
	}
}
