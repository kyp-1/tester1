package p0218;

import java.util.HashMap;
import java.util.Map;

public class ListMap3 {

	public static void main(String[] args) {
		Map<String,String> user1 = new HashMap<>();
		user1.put("UI_NAME", "성룡");
		user1.put("UI_ID", "SUNG");
		user1.put("UI_PWD", "1234");
		Map<String,String> user2 = new HashMap<>();
		user2.put("UI_NAME", "홍길동");
		user2.put("UI_ID", "qwer");
		user2.put("UI_PWD", "1234");
		Map<String,String> user3 = new HashMap<>();
		user3.put("UI_NAME", "홍길동");
		user3.put("UI_ID", "hong");
		user3.put("UI_PWD", "r1r2r3");
		Map<String,String> user4 = new HashMap<>();
		user4.put("UI_NAME", "홍길동");
		user4.put("UI_ID", "hong");
		user4.put("UI_PWD", "r1r2r3");
		Map<String,String> user5 = new HashMap<>();
		user5.put("UI_NAME", "홍길동");
		user5.put("UI_ID", "hong");
		user5.put("UI_PWD", "r1r2r3");
		
	}
}
