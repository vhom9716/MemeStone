package cards;

import java.util.*;

public class Deck {
	

	static ArrayList<Card> deck= new ArrayList<Card>();
	
	public Deck() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void addCard(Card card) {
		if(deck.size() < 16) {
			deck.add(card);
		}
	}
	
	public void deleteCard(Card c) {
		deck.remove(c);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}

}
