package battle;

import java.util.ArrayList;

public class AI {
	public ArrayList<Card> deck;
	public ArrayList<Card> hand;
	public int health;
	public ArrayList<Card> board;
	
	public Card[] getBoard() {
		return board;
	}
	
	public int changeHealth(int change) {
		health += change;
	}
	
	public void draw() {
		if(deck.size() == 0) {
			lose();
		}
	} 

	private void lose() {
		// TODO Auto-generated method stub
		
	}
}
