package p0212;

import java.util.ArrayList;

public class ListTest2 {
	
	public static void main(String[] args) {
		//5개의 게임을 만들어주세요.
		/*
		 * 1. name=삼국지, price=30000, genre=전략
		 * 2. name=LOL, price=0, genre=실시간전략
		 * 3. name=카트라이더, price=0, genre=스포츠
		 * 4. name=스타크래프트, price=15000, genre=실시간전략
		 * 5. name=오버워치, price=32000, genre=RTS
		 */
		
		Game g1 = new Game();
		
		g1.setName("삼국지");
		g1.setPrice(30000);
		g1.setGenre("전략");
		
		Game g2 = new Game();
		g2.setName("LOL");
		g2.setPrice(0);
		g2.setGenre("실시간전략");
		
		Game g3 = new Game();
		g3.setName("카트라이더");
		g3.setPrice(0);
		g3.setGenre("스포츠");
		
		Game g4 = new Game();
		g4.setName("스타크래프트");
		g4.setPrice(15000);
		g4.setGenre("실시간전략");
		
		Game g5 = new Game();
		g5.setName("오버워치");
		g5.setPrice(32000);
		g5.setGenre("RTS");
		
		ArrayList<Game> gameList = new ArrayList<>();
		gameList.add(g1);
		gameList.add(g2);
		gameList.add(g3);
		gameList.add(g4);
		gameList.add(g5);
		
		for(int i=0;i<gameList.size();i++) {
			Game g = gameList.get(i);
			System.out.println(g);
		}
		System.out.println();
		
		for(Game g:gameList) {
			if(g.getGenre().indexOf("전략")!=-1 && g.getPrice()!=0) { //.contains("전략")도 사용가능
				System.out.println(g);
			}
		}
		System.out.println();
		
		for(Game g:gameList) {
			if(g.getPrice()>=15000 && g.getPrice()<30000) {
				System.out.println(g);
			}
		}
		
	}
}
