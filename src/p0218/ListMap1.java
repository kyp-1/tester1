package p0218;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMap1 {

	static List<Map<String, String>> getUserInfo(){

		Map<String,String> map1 = new HashMap<>();
		map1.put("이름", "홍길동");
		map1.put("age", "22");
		map1.put("id", "hong");
		Map<String,String> map2 = new HashMap<>();
		map2.put("이름", "임꺽정");
		map2.put("age", "33");
		map2.put("id","lim");
		Map<String,String> map3 = new HashMap<>();
		map3.put("이름", "유관순");
		map3.put("age", "16");
		map3.put("id", "yu");
		List<Map<String,String>> maps = new ArrayList<>();
		maps.add(map1);
		maps.add(map2);
		maps.add(map3);
		return maps;
	}
	public static void main(String[] args) {
		List<Map<String,String>> users = getUserInfo();
		for(int i=0;i<users.size();i++) {
			Map<String,String> user = users.get(i);
			System.out.print("이름 : " + user.get("name"));
			System.out.print(",아이디 : " + user.get("id"));
			System.out.println(",나이 : " + user.get("age"));
		}
		for(Map<String,String> user : users) {
			System.out.print("이름 : " + user.get("name"));
			System.out.print(",아이디 : " + user.get("id"));
			System.out.println(",나이 : " + user.get("age"));
		}
	}
}
