package battle;

import java.util.ArrayList;

import cards.Card;

public class Player {
	public ArrayList<Card> deck;
	public ArrayList<Card> hand;
	public ArrayList<Card> board;
	public int health;
	public int currentmana;
	public int maxmana;
	
	public Player() {
		maxmana = 0;
		health = 30;
		currentmana = 0;
	}
	public void drawcard() {
		Card x = deck.get(0);
		deck.remove(0);
		hand.add(x);
	}
	
	public void declareAttack(Card attacker,Card victim) {
		
	}
	
 
}
