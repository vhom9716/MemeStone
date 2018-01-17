package battle;

import java.util.ArrayList;

import cards.Card;

public class Player {
	public ArrayList<Card> deck;
	public ArrayList<Card> hand;
	public ArrayList<Card> board;
	public boolean[] playable; 
	public int health;
	public int currentmana;
	public int maxmana;
	
	public Player() {
		maxmana = 10;
		health = 30;
		currentmana = 0;
		sendinfortofront();
	}
	private boolean[] sendinfortofront() {
		playable=new boolean[hand.size()];
		for(int i=0;i<hand.size();i++) {
			if(hand.get(i).mana>currentmana) {
				playable[i]=false;
			}else {
				playable[i]=true;
			}
		}
		return playable;
		
	}
	public void drawcard() {
		Card x = deck.get(0);
		deck.remove(0);
		hand.add(x);
	}
	public void changehp(int change) {
		health+=change;
	}
	public void playcard(Card x) {
		currentmana-=x.mana;
		board.add(x);
		hand.remove(x);
		sendinfortofront();
		
	}
	
	public void declareAttack(Card attacker,Card victim) {
		
	}
	
 
}
