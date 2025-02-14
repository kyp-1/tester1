package p0214;

public class Print {

	public static void main(String[] args) {
		int age = 1;
		String name = "홍길동";
		System.out.println("나이 :" + age + ", 이름 :" + name);
		System.out.printf("나이 : %d, 이름 : %s", age, name); //%d 뒤에는 숫자 %s 뒤에는 스트링
	}
}
